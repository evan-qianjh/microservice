package com.qianjh.microservice.controller;

import com.qianjh.microservice.service.SequenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;

/**
 * @author QianJH
 * @date 2017/11/14
 */
@Slf4j
@RestController
@RequestMapping("/sequence")
public class SequenceController {
    @Autowired
    private SequenceService sequenceService;

    /**
     * 获取递增序列
     *
     * @param id 序列ID
     * @return
     */
    @RequestMapping(value = "/createIncrementSeq", method = RequestMethod.POST)
    Queue<Long> createIncrementSeq(Long id) {
        return sequenceService.createIncrementSeq(id);
    }

    /**
     * 获取规则序列
     *
     * @param id 序列ID
     * @return
     */
    @RequestMapping(value = "/createRuleSeq", method = RequestMethod.POST)
    Queue<String> createRuleSeq(Long id) {
        return sequenceService.createRuleSeq(id);
    }
}
