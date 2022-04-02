package com.yc.example.cxf.config;

import com.yc.example.cxf.service.UserService;
import com.yc.example.cxf.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: youcong
 */
@Configuration
public class CxfConfig {
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    /**
     * 发布服务并指定访问URL
     *
     * @return
     */
    @Bean
    public EndpointImpl userEnpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), userService());
        endpoint.publish("/user");
        return endpoint;
    }


}
