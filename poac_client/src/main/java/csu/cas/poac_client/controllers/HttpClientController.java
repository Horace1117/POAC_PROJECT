package csu.cas.poac_client.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csu.cas.poac_client.http.HttpAPIService;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;


@RestController
public class HttpClientController {

    @Resource
    private HttpAPIService httpAPIService;

    @RequestMapping("httpclient")
    public String test() throws Exception {
    	Map<String,Object> requestParamMap = new HashMap<String,Object>();
    	requestParamMap.put("timeStart", "20151223233434");
    	requestParamMap.put("timeStop", "20151223233434");
        String str = httpAPIService.doGet("http://localhost:8080/v1/oim/downlinkPlan",requestParamMap);
        return str;
    }
}
