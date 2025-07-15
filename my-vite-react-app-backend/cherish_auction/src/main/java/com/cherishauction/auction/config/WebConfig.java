package com.cherishauction.auction.config; // 패키지는 구조에 맞게

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // /api로 시작하는 경로는 제외하고 나머지는 index.html로 포워딩
        registry.addViewController("/{spring:^(?!api).*}")
                .setViewName("forward:/index.html");
        registry.addViewController("/**/{spring:^(?!api).*}")
                .setViewName("forward:/index.html");
        registry.addViewController("/{spring:^(?!api).*}/**{spring:^(?!.*\\.(js|css|png|jpg|ico)$).*$}")
                .setViewName("forward:/index.html");
    }
}
