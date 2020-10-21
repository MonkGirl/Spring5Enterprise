package com.monkgirl.spring5.chapter18.configuration;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-20 14:54
 * @description
 */
public class DemoTableShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        for (String databaseName : collection) {
            // 数据库后缀名
            String suffix = String.valueOf(preciseShardingValue.getValue() % 2);
            if (databaseName.endsWith(suffix)) {
                return databaseName;
            }
        }
        throw new IllegalStateException("参数异常！");
    }
}
