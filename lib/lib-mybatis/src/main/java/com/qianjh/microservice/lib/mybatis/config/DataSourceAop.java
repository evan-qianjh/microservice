package com.qianjh.microservice.lib.mybatis.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author QianJH
 * @date 2017/10/16
 */
@Slf4j
@Aspect
@Order(1)
@Component
public class DataSourceAop {

    /**
     * 遇到开启事务时，将数据源切换为写
     */
    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void setReadDataSourceType() {
        DataSourceContextHolder.write();
    }

    /**
     * 事务方法结束后，切换数据源为读
     */
    /*@After("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.read();
    }*/

}
