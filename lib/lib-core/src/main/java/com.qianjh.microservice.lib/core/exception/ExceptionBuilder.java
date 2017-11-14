package com.qianjh.microservice.lib.core.exception;

/**
 * 异常构造器
 *
 * @author QianJH
 */
public final class ExceptionBuilder {

    /**
     * 构建服务异常
     *
     * @param msg 异常描述
     * @return
     */
    public static ServiceException serviceException(String msg) {
        throw new ServiceException(msg);
    }


    /**
     * 对象不存在异常
     *
     * @param obj
     * @param key
     * @param val
     * @return
     */
    public static ObjectNotFoundException objectNotFoundException(String obj, String key, String val) {
        throw new ObjectNotFoundException("[obj:" + obj + "][key:" + key + "][val:" + val + "]不存在");
    }
}
