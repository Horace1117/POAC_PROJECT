package csu.cas.poac.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/v1/oim")
public class ApiController {
	@Autowired
	private MetadataServiceImpl metadataService;
	@Autowired
	private PlanServiceImpl planService;

	@GetMapping(value ="/downlinkPlan",produces ="application/json")
	public ResponseEntity<?> getDownlinkPlan(@RequestParam("timeStart") String timeStart,@RequestParam("timeStop")String timeStop) {
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
