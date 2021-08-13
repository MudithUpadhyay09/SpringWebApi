package com.example.demo.WebMvcConfigurer;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class SwaggerUiWebMvcConfigurer implements WebMvcConfigurer {
	 private final String baseUrl;

	 public SwaggerUiWebMvcConfigurer(String baseUrl) { //
	   this.baseUrl = baseUrl;
	 }

@Override
/**
	 * Add handlers to serve static resources such as images, js, and, css
	 * files from specific locations under web application root, the classpath,
	 * and others.
	 * @see ResourceHandlerRegistry
 */
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	   String baseUrl = StringUtils.trimTrailingCharacter(this.baseUrl, '/');
	   registry.
	     addResourceHandler(baseUrl + "/swagger-ui/**")
	     .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
	       .resourceChain(false);
	 }

/**
 	* Configure simple automated controllers pre-configured with the response
 	* status code and/or a view to render the response body. This is useful in
 	* cases where there is no need for custom controller logic -- e.g. render a
 	* home page, perform simple site URL redirects, return a 404 status with
 	* HTML content, a 204 with no content, and more.
 	* @see ViewControllerRegistry
*/
	@Override
	 
	 public void addViewControllers(ViewControllerRegistry registry) {
	   registry.addViewController(baseUrl + "/swagger-ui/")
	       .setViewName("forward:" + baseUrl + "/swagger-ui/index.html");
	 }
}
