package csu.cas;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class PoacEurekaServerApplication
{
    public static void main( String[] args )
    {
        new SpringApplicationBuilder(PoacEurekaServerApplication.class).web(true).run(args);
    }

}
