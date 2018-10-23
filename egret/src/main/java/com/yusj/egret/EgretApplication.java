package com.yusj.egret;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @Author kakalgy
 * @Date 2018/10/21 18:09
 **/
@SpringBootApplication
@EnableWebMvc
public class EgretApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(EgretApplication.class);

    public static void main(String[] args) {
        LOGGER.info("#########Egret Application start#########");
        SpringApplication.run(EgretApplication.class, args);

    }
}
