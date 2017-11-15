package com.qianjh.microservice.service.impl;

import com.qianjh.microservice.lib.core.exception.ExceptionBuilder;
import com.qianjh.microservice.model.sequence.domain.Sequence;
import com.qianjh.microservice.repository.SequenceRepository;
import com.qianjh.microservice.service.SequenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author QianJH
 * @date 2017/11/14
 */
@Slf4j
@Service
public class SequenceServiceImpl implements SequenceService {

    @Autowired
    private SequenceRepository repository;

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Queue<Long> createIncrementSeq(Long id) {
        Sequence tbSequence = repository.findOneForUpdate(id);
        if(tbSequence == null) {
            ExceptionBuilder.serviceException("序列[" + id + "]不存在");
        }
        Queue<Long> queue = new LinkedList<>();
        for (int i = 1; i <= tbSequence.getIncrement(); i++) {
            queue.offer(tbSequence.getCurrentValue() + i);
        }
        tbSequence.setCurrentValue(tbSequence.getCurrentValue() + tbSequence.getIncrement());
        repository.save(tbSequence);
        log.info("生成序列：" + queue.toString());
        return queue;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Queue<String> createRuleSeq(Long id) {
        Sequence tbSequence = repository.findOneForUpdate(id);
        if(tbSequence == null) {
            ExceptionBuilder.serviceException("序列[" + id + "]不存在");
        }
        Queue<String> queue = new LinkedList<>();
        for (int i = 1; i <= tbSequence.getIncrement(); i++) {
            String f = fillRule(tbSequence.getRule(), tbSequence.getCurrentValue() + i);
            queue.offer(f);
        }
        tbSequence.setCurrentValue(tbSequence.getCurrentValue() + tbSequence.getIncrement());
        repository.save(tbSequence);
        log.info("生成序列：" + queue.toString());
        return queue;
    }

    private static final Pattern datePattern = Pattern.compile("\\{(\\w+)\\}");
    private static final Pattern numberPattern = Pattern.compile("\\[(\\d+)\\]");
    private String fillRule(String rule, Long number) {
        //替换日期
        Matcher dm = datePattern.matcher(rule);
        while (dm.find()) {
            String group = dm.group(1);
            rule = rule.replace("{" + group + "}", new SimpleDateFormat(group).format(new Date()));
        }

        //替换数字
        Matcher nm = numberPattern.matcher(rule);
        while (nm.find()) {
            String group = nm.group(1);
            String num = String.format("%0"+ Integer.valueOf(group) + "d", number);
            rule = rule.replace("[" + group + "]", num);
        }

        return rule;
    }
}
