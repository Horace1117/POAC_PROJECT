package csu.cas.poac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Hello world!
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
public class PoacServerApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(PoacServerApplication.class,args);
    }
}
