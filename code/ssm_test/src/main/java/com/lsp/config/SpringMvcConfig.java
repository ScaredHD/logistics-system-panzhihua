package com.lsp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author:
 * @createTime: 2022年07月02日 09:42:49
 * @version: 1.0
 * @Description:
 */
@Configuration
@ComponentScan("com.lsp.controller")
@EnableWebMvc
public class SpringMvcConfig {

}
