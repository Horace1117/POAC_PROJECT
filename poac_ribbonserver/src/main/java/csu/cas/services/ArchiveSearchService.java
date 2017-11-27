package csu.cas.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by horacegao on 17/11/27.
 */
@Service
public class ArchiveSearchService {
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String searchService() {
        return restTemplate.getForEntity("http://ARCHIVE-SEARCH-SERVICE/v1/oim/downlinkPlan?" +
                "timeStart=20151223233434&timeStop=20151323234334", String.class).getBody();
    }
    public String addServiceFallback() {
        return "error";
    }
}
