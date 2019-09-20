package com.qjx.hotService;

import com.qjx.aop.DynamicDataSourceAnnotationAdvisor;
import com.qjx.aop.DynamicDataSourceAnnotationInterceptor;
import com.qjx.register.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import({DynamicDataSourceRegister.class})
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.qjx.hot.*"})
@MapperScan("com.qjx.hot.dao")
public class HotServiceApplication {

    @Bean
    public DynamicDataSourceAnnotationAdvisor dynamicDatasourceAnnotationAdvisor() {
        return new DynamicDataSourceAnnotationAdvisor(new DynamicDataSourceAnnotationInterceptor());
    }

    public static void main(String[] args) {
        SpringApplication.run(HotServiceApplication.class, args);
    }

}
