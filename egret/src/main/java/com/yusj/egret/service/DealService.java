package com.yusj.egret.service;

import com.yusj.egret.dao.DealDao;
import com.yusj.egret.model.core.Battery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author kakalgy
 * @Date 2018/11/3 13:44
 **/
@Service
public class DealService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DealService.class);

    @Autowired
    private DealDao dealDao;

    @Transactional(rollbackFor = Exception.class)
    public int deal(Battery battery) {
        return dealDao.insertTransaction(battery);
    }
}
