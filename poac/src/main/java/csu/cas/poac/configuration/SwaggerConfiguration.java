package csu.cas.poac.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfiguration {
	@Value("${server.servlet-path}")
	private String pathMapping;
	private ApiInfo initApiInfo() {
		ApiInfo apiInfo = new ApiInfo("POAC Platform API", // 大标题
				initContextInfo(), // 简单的描述
				"1.0.0", // 版本
				"服务条款", "后台开发团队", // 作者
				"The Apache License, Version 1.0", // 链接显示文字
				""// 网站链接
		);
		return apiInfo;
	}
	private String initContextInfo() {
		StringBuffer sb = new StringBuffer();
		sb.append("POAC项目的 REST API");
		return sb.toString();
	}
 
	@Bean
	public Docket restfulApi() {
		System.out.println("http://localhost:8080" + pathMapping + "/swagger-ui.html");
		return new Docket(DocumentationType.SWAGGER_2).groupName("RestfulApi")
				// .genericModelSubstitutes(DeferredResult.class)
				.genericModelSubstitutes(ResponseEntity.class).useDefaultResponseMessages(true).forCodeGeneration(false)
				.pathMapping(pathMapping) // base，最终调用接口后会和paths拼接在一起
				.select().paths(doFilteringRules()).build().apiInfo(initApiInfo());
		// .select().paths(Predicates.not(PathSelectors.regex("/error.*"))).build().apiInfo(initApiInfo());
 
	}
 
	private Predicate<String> doFilteringRules() {
		return Predicates.not(PathSelectors.regex("/error.*"));

	}

}
