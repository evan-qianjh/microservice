package com.qianjh.microservice.lib.mybatis.config;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author QianJH
 * @date 2017/10/16
 */
@AllArgsConstructor
@Getter
public enum DataSourceType {
    read("read", "从库"), write("write", "主库");

    private String type;
    private String name;
}
