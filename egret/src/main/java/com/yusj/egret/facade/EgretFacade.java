package com.yusj.egret.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author kakalgy
 * @Date 2018/10/21 21:50
 **/
@RestController
public class EgretFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(EgretFacade.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String egretRoot(){
        LOGGER.info("This is Root Egret");
        return "ok";
    }
}
