package com.lsp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author:
 * @createTime: 2022年07月03日 10:39:56
 * @version: 1.0
 * @Description:
 */
@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    protected void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("css/**").addResourceLocations("/css/");
        registry.addResourceHandler("js/**").addResourceLocations("/js/");
        registry.addResourceHandler("plugins/**").addResourceLocations("/plugins/");
    }
}
