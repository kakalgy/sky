package com.yusj.egret.dao;

import com.yusj.egret.model.core.Battery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author kakalgy
 * @Date 2018/11/3 13:45
 **/
@Repository
public class DealDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DealDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertTransaction(Battery battery) {

        String sql = "INSERT INTO `cruiser`.`battery` (`uuid`, `quantity`, `direction`, `price`, `time`, `crew_id`) VALUES (?,?,?,?,?,?);";
        return jdbcTemplate.update(sql, battery.getUuid(), battery.getQuantity(), battery.isDirection(), battery.getPrice(), battery.getTime(), battery.getCrewId());
    }
}
