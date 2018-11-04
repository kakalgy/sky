package com.yusj.egret.facade;

import com.yusj.egret.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author kakalgy
 * @Date 2018/11/3 14:51
 **/
@RestController
public class AccountFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountFacade.class);

    @Autowired
    private AccountService accountService;


}
