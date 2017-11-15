package com.qianjh.microservice.client.sequence;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Queue;

/**
 * @author QianJH
 * @date 2017/11/14
 */
@FeignClient("service-sequence")
public interface SequenceClient {
    /**
     * 创建递增序列
     *
     * @param id 序列ID
     * @return
     */
    @RequestMapping(value = "/sequence/createIncrementSeq", method = RequestMethod.POST)
    Queue<Long> createIncrementSeq(@RequestParam("id") Long id);

    /**
     * 创建规则序列
     *
     * @param id 序列名称
     * @return
     */
    @RequestMapping(value = "/sequence/createRuleSeq", method = RequestMethod.POST)
    Queue<String> createRuleSeq(@RequestParam("id") Long id);
}
