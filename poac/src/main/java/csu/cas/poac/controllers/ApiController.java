package csu.cas.poac.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import csu.cas.poac.model.CctcRaw;
import csu.cas.poac.model.Plan;
import csu.cas.poac.services.MetadataServiceImpl;
import csu.cas.poac.services.PlanServiceImpl;
import csu.cas.poac.util.DateUtils;
import csu.cas.poac.valueobject.MetadataCtccRawForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;

@RestController
@RequestMapping("/v1/oim")
@Api(value = "API - ApiController")
public class ApiController {
	private final Logger logger = Logger.getLogger(getClass());
	@Autowired
	private DiscoveryClient client;
	@Autowired
	private MetadataServiceImpl metadataService;
	@Autowired
	private PlanServiceImpl planService;

	@ApiOperation(value = "查找下行计划", httpMethod = "GET", response = Response.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "timeStart", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "timeStop", required = true, dataType = "String", paramType = "query") })
	@GetMapping(value ="/downlinkPlan",produces ="application/json")
	public ResponseEntity<?> getDownlinkPlan(@RequestParam("timeStart") String timeStart,@RequestParam("timeStop")String timeStop) {
		ServiceInstance instance = client.getLocalServiceInstance();
		logger.info("/downlinkPlan,host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
		Collection<Plan> downlinkPlan;
		Map<String,Object> map = new HashMap<String,Object>();
		//检查日期格式
	   try {
			DateUtils.stringToDate(timeStart);
			DateUtils.stringToDate(timeStop);
	   } catch (ParseException e) {
			map.put("statuscode", "400");
			map.put("message", "检索条件错误");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
	   } 
		try {
			downlinkPlan = planService.getDownlinkPlanByTime(timeStart,timeStop);
			//是否有符合条件的数据
			if(downlinkPlan == null||downlinkPlan.size()==0){
				map.put("statuscode", "404");
				map.put("message", "找不到符合条件的数据下行计划");
				return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Collection<Plan>>(downlinkPlan,HttpStatus.OK);	
		} catch (Exception ex) {
			map.put("statuscode", "500");
			map.put("message", "服务器出错");
			map.put("exception", ex);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	@ApiOperation(value = "CCTC原始文件归档", httpMethod = "POST", response = Response.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "cctcRawForm", required = true, dataType = "MetadataCtccRawForm", paramType = "body")
		})
	@PostMapping(value = "/ctccRawMetadata",produces ="application/json")
	public ResponseEntity<?> archiveCtccRawMetadata(@RequestBody MetadataCtccRawForm cctcRawForm) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			CctcRaw cctcRaw  =metadataService.archiveCtccRawMetadata(cctcRawForm);
			map.put("statuscode", "200");
			map.put("message", "操作成功");
			map.put("savestatus", cctcRaw);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		} catch (Exception ex) {
			map.put("statuscode", "500");
			map.put("message", "服务器出错");
			map.put("exception", ex);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
}
