package com.monkgirl.spring5.chapter18.configuration;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-20 20:41
 * @description
 */
public class DemoDatabaseHintShardingAlgorithm implements HintShardingAlgorithm<Integer> {
    @Override
    public Collection<String> doSharding(Collection<String> collection, HintShardingValue<Integer> hintShardingValue) {
        Collection<String> result = new ArrayList<>();
        for (String each : collection) {
            for (Integer value : hintShardingValue.getValues()) {
                if (each.endsWith(String.valueOf(value % 2))) {
                    result.add(each);
                }
            }
        }
        return result;
    }
}
