package com.qianjh.microservice.service;

import java.util.Queue;

/**
 * @author QianJH
 * @date 2017/11/14
 */
public interface SequenceService {

    /**
     * 获取递增序列
     *
     * @param id
     * @return
     */
    Queue<Long> createIncrementSeq(Long id);

    /**
     * 获取规则序列
     *
     * @param id
     * @return
     */
    Queue<String> createRuleSeq(Long id);
}
