package com.qianjh.microservice.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.Queue;

/**
 * @author QianJH
 */
public interface SequenceService {

    /**
     * 创建递增序列
     *
     * @param seqName 序列名称
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    Queue<Long> createIncrementSeq(String seqName);

    /**
     * 创建规则序列
     *
     * @param seqName 序列名称
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    Queue<String> createRuleSeq(String seqName);
}
