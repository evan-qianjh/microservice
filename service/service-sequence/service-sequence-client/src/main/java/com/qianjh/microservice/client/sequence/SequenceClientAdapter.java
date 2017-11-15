package com.qianjh.microservice.client.sequence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 存储客户端实现
 *
 * @author QianJH
 * @date 2017/10/27
 */
@Component
@Slf4j
public class SequenceClientAdapter {

    @Autowired
    private SequenceClient client;

    /**
     * 递增序列
     */
    private static Map<Long, Queue<Long>> incrementMap = new HashMap<>();
    /**
     * 规则序列
     */
    private static Map<Long, Queue<String>> ruleMap = new HashMap<>();

    /**
     * 获取递增序列
     *
     * @param id 序列ID
     * @return
     */
    public synchronized Long getIncrementSeq(Long id) {
        Queue<Long> queue = incrementMap.get(id);
        //序列使用完毕
        if (queue == null || queue.isEmpty()) {
            //生成一批新序列
            Queue<Long> ids = client.createIncrementSeq(id);
            log.info("预生成[" + id + "]序列: " + ids);
            incrementMap.put(id, ids);
        }
        return incrementMap.get(id).poll();
    }

    /**
     * 获取规则序列
     *
     * @param id 序列ID
     * @return
     */
    public synchronized String getRuleSeq(Long id) {
        Queue<String> queue = ruleMap.get(id);
        //序列使用完毕
        if (queue == null || queue.isEmpty()) {
            //生成一批新序列
            Queue<String> ids = client.createRuleSeq(id);
            log.info("预生成[" + id + "]序列: " + ids);
            ruleMap.put(id, ids);
        }
        return ruleMap.get(id).poll();
    }
}
