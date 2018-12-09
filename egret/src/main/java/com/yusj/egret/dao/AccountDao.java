package com.yusj.egret.dao;

import com.yusj.egret.model.core.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description
 * @Author kakalgy
 * @Date 2018/11/3 14:49
 **/
@Repository
public class AccountDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Account queryAccountByName(String name) {
        String sql = "select a.id, a.name, b.total, b.available, b.reinforce, c.uuid,c.quantity, c.cost, c.current_price from crew as a left join committee as b " +
                "on a.id = b.id left join hangar c on b.id = c.crew_id;";
        jdbcTemplate.query(sql, new RowMapper<Account>() {
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                return null;
            }
        });
        return null;
    }
}
