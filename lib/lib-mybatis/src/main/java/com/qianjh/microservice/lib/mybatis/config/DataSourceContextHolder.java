package com.qianjh.microservice.lib.mybatis.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author QianJH
 * @date 2017/10/16
 */
@Slf4j
public class DataSourceContextHolder {
    @Getter
    private static final ThreadLocal<String> local = new ThreadLocal<>();

    public static void read() {
        if(DataSourceType.write.getType().equals(getJdbcType())) {
            log.debug("无法切换至数据源 -> 从，当前数据源已被锁定为 -> 写");
            return;
        }
        local.set(DataSourceType.read.getType());
        log.debug("切换数据源 -> 从");
    }

    public static void write() {
        local.set(DataSourceType.write.getType());
        log.debug("切换数据源 -> 主");
    }

    public static String getJdbcType() {
        return local.get();
    }
}
