package com.monkgirl.spring5.chapter18.configuration;

import com.monkgirl.spring5.chapter18.util.DataSourceUtil;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.HintShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-20 11:46
 * @description
 */
@Configuration
public class DataSourceConfig {

    @Bean("dataSourceSharding")
    DataSource getShardingDataSource() throws SQLException {
        ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();
        // 表配置规则
        shardingRuleConfiguration.getTableRuleConfigs().add(getUserTableRuleConfiguration());
        // 表的组成
        shardingRuleConfiguration.getBindingTableGroups().add("shop_info");
        // DataSource的分片策略
        //shardingRuleConfiguration.setDefaultDatabaseShardingStrategyConfig(
         //      new StandardShardingStrategyConfiguration("shop_id", new DemoDatabaseShardingAlgorithm())
        //);
        shardingRuleConfiguration.setDefaultDatabaseShardingStrategyConfig(new HintShardingStrategyConfiguration(new DemoDatabaseHintShardingAlgorithm()));
        // Table的分片策略
//        shardingRuleConfiguration.setDefaultTableShardingStrategyConfig(
//                new StandardShardingStrategyConfiguration("shop_id", new DemoTableShardingAlgorithm())
//        );
        shardingRuleConfiguration.setDefaultTableShardingStrategyConfig(new HintShardingStrategyConfiguration(new DemoTableHintShardingAlgorithm()));
        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), shardingRuleConfiguration, new Properties());
    }

    @Bean
    TableRuleConfiguration getUserTableRuleConfiguration() {
        // 逻辑表shop_info
        String logicTable = "shop_info";
        // 实际物理节点
        String actualDataNodes = "shop_${0..1}.shop_info_${0..1}";
        TableRuleConfiguration tableRuleConfiguration = new TableRuleConfiguration(logicTable, actualDataNodes);
       // tableRuleConfiguration.setKeyGeneratorConfig(new KeyGeneratorConfiguration("UUID", "shop_id"));
        tableRuleConfiguration.setKeyGeneratorConfig(new KeyGeneratorConfiguration("SNOWFLAKE", "shop_id"));
        return tableRuleConfiguration;
    }

    private Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("shop_0", DataSourceUtil.createDataSource("shop_0"));
        dataSourceMap.put("shop_1", DataSourceUtil.createDataSource("shop_1"));
        return dataSourceMap;
    }
}
