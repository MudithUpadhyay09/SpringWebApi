package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	  /**
	    * Docket is a builder which is intended to be the primary interface into the swagger-spring mvc framework.
	    * It provides sensible defaults and convenience methods for configuration.
	    * @Docket
	    */
	@Bean
	   public Docket scrumAllyApi() {
	       return new Docket(DocumentationType.SWAGGER_2)//In Swagger 2.0, the API end point URL definition is broken into 3 components : host, basePath and schemas 
	    		   										// and the end point URL is a combination of these component values.According to this spec, you can define only one end point URL for a given API.
	               .select() 							//SELECT--calling its select() method returns an instance of ApiSelectorBuilder, which provides control over the end points exposed by Swagger.
	               										//JB- it is used for builder object 
	               .paths( PathSelectors.any())  		//The paths() method further defines for which paths in our APIs do we want to create documentation for.
	               										//If you'd wish to include all end points - you can easily do so by using PathSelectors.any()
	               .build()
	               .apiInfo(apiInfo());
	   }

	   private ApiInfo apiInfo() {
	       return new ApiInfoBuilder()
	               .title("School Management")
	               .description("It is Description of School")
	               .version("1.2.2")  //(this will show the version)
	               .termsOfServiceUrl("")
	               //.licenseUrl("what")
	            
	               .build();
	   }
	}
	
