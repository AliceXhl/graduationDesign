package com.hf.springbootinit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局跨域配置
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 覆盖所有请求
        registry.addMapping("/**") // 允许所有接口的跨域请求
                .allowCredentials(true) // 允许发送 Cookie
                .allowedOriginPatterns("*") // 允许所有来源
                .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"}) // 允许的请求方法
                .allowedHeaders("*") // 允许的请求头
                .exposedHeaders("*"); // 暴露给客户端的响应头
    }
//    @Bean
//    public CookieSerializer cookieSerializer(){
//        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
//        cookieSerializer.setCookieName("COOKIE_SESSION");
//        cookieSerializer.setSameSite("None");
//        cookieSerializer.setUseSecureCookie(true);
//        return cookieSerializer;
//    }
}
