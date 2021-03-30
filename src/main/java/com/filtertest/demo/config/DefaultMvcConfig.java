package com.filtertest.demo.config;


import com.filtertest.demo.filter.TimeFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @desc: mvc config
 * @author: liuhongdi
 * @date: 2020-07-01 11:40
 */
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class DefaultMvcConfig implements WebMvcConfigurer {


    //add filter
     //registration.addUrlPatterns("/icons/*", "/style/*", "/script/*", "/dwr/*", "/icons/*", "/coverArt.view", "/avatar.view");
    //registration.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid2/*");

    @Bean
    public FilterRegistrationBean addTimeFilterBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new TimeFilter());
        registration.setName("timeFilter");
        registration.setOrder(1);  //请求中过滤器执行的先后顺序，值越小越先执行
        registration.addUrlPatterns("/home/*","/abc/*");
        return registration;
    }

}