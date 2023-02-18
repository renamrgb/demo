package com.renamrgb.demo.infra.config;

import com.renamrgb.demo.infra.config.organization.OrganizationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new OrganizationInterceptor())
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/h2-console/**");
    }

}
