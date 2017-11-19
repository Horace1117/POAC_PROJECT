package csu.cas.poac_client.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csu.cas.poac_client.http.HttpAPIService;
import csu.cas.poac_client.http.HttpResult;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;


@RestController
@RequestMapping("/httpclient")
public class HttpClientController {

    @Resource
    private HttpAPIService httpAPIService;

    @RequestMapping("/downlinkPlan")
    public String downLinkPlan() throws Exception {
    	Map<String,Object> requestParamMap = new HashMap<String,Object>();
    	requestParamMap.put("timeStart", "20151232434");
    	requestParamMap.put("timeStop", "20151223233434");
        String str = httpAPIService.doGet("http://localhost:8080/v1/oim/downlinkPlan",requestParamMap);
        return str;
    }
    @RequestMapping("/ctccRawMetadata")
    public String ctccRawMetadata() throws Exception {
    	Map<String,Object> requestParamMap = new HashMap<String,Object>();
    	requestParamMap.put("st","TS");
    	requestParamMap.put("tlNo","TL1A1");
    	requestParamMap.put("recvBegTime","20171112094200");
    	requestParamMap.put("fileBegTime","20171112104200");
    	requestParamMap.put("fileGeneratedTime","20171112114200");
    	requestParamMap.put("mb","M");
    	requestParamMap.put("seq",1);
    	requestParamMap.put("ext","raw");
    	String str = httpAPIService.doPost("http://localhost:8080/v1/oim/ctccRawMetadata",requestParamMap);
        return str;
    }
}
