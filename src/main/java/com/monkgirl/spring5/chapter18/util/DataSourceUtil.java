package com.monkgirl.spring5.chapter18.util;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-20 15:17
 * @description
 */
public class DataSourceUtil {
    private DataSourceUtil(){}

    public static DataSource createDataSource(final String dataSourceName){
        Properties properties = new Properties();
        try {
            properties.load(DataSourceUtil.class.getResourceAsStream("/sharding-jdbc/jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        HikariDataSource result = new HikariDataSource();
        result.setDriverClassName(properties.getProperty("jdbc.driverClassName"));
        result.setJdbcUrl(String.format("jdbc:mysql://%s:%s/%s?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=UTF-8",
                properties.getProperty("jdbc.host"),
                properties.getProperty("jdbc.ip"),
                dataSourceName));
        result.setUsername(properties.getProperty("jdbc.username"));
        result.setPassword(properties.getProperty("jdbc.password"));
        return result;
    }
}
