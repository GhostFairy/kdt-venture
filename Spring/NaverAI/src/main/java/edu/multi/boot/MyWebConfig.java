package edu.multi.boot;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 설정 내용을 일부 포함하고 있으므로 설정을 읽을 때 같이 읽으라는 의미
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// C:/upload 폴더를 /upload URL로 매핑
		registry.addResourceHandler("/upload/**").addResourceLocations("file:///c:/upload/");
		registry.addResourceHandler("/ai_images/**").addResourceLocations("file:///C:/ai_images/");
	}

}
