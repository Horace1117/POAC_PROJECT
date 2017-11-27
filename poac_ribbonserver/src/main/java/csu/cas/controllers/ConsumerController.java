package csu.cas.controllers;

import csu.cas.services.ArchiveSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by horacegao on 17/11/27.
 */
@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ArchiveSearchService archiveSearchService;

        @RequestMapping(value = "/downlinkPlan", method = RequestMethod.GET)
        public String getDownlinkPlan() {
            return archiveSearchService.searchService();
        }
}
