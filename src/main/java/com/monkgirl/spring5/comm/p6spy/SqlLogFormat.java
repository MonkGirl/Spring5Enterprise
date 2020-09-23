package com.monkgirl.spring5.comm.p6spy;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

import java.time.LocalDateTime;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-23 11:12
 * @description
 */
public class SqlLogFormat implements MessageFormattingStrategy {

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String s) {
        return !"".equals(sql.trim())
                ?
                "[ " + LocalDateTime.now() + " ] --- | took " + elapsed + "ms | " + prepared + "|" + category + " | connection " + connectionId + "\n "
                        + sql + ";"
                : "";
    }

}
