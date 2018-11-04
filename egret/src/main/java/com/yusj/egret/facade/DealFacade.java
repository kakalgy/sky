package com.yusj.egret.facade;

import com.yusj.egret.model.core.Battery;
import com.yusj.egret.model.major.ReturnObject;
import com.yusj.egret.service.DealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author kakalgy
 * @Date 2018/11/3 13:18
 **/
@RestController
public class DealFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(DealFacade.class);

    @Autowired
    private DealService dealService;

    @RequestMapping(value = "/deal", method = RequestMethod.POST)
    public ReturnObject<Integer> deal(Battery battery) {
        ReturnObject<Integer> result = new ReturnObject<Integer>();
        int num = dealService.deal(battery);
        result.setSuccess(true);
        result.setResult(num);

        return result;
    }


}
