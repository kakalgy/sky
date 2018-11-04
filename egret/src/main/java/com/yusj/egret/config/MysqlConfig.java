package com.yusj.egret.config;

import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * * 文档：https://docs.spring.io/spring-boot/docs/2.0.1.RELEASE/reference/htmlsingle/
 * * ------29.1.2 Connection to a Production Database
 * * </p>
 * * <ul>
 * * <li>spring-boot默认的会根据application.properties注册两个Bean，分别为
 * * <ul>
 * * <li>JdbcTemplate</li>
 * * <li>NamedParameterJdbcTemplate</li>
 * * </ul>
 * * 调用的时候可以直接使用，其他的Bean需要自己创建</li>
 * * <li></li>
 * * <li></li>
 * * </ul>
 *
 * @Author kakalgy
 * @Date 2018/11/3 13:50
 **/
@Configuration
public class MysqlConfig {

    ///////////////////////////////////////////////
    //
    // JdbcTemplate和NamedParameterJdbcTemplate
    // 已经自动注册，不需要再配置Bean
    ///////////////////////////////////////////////


}
