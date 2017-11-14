package com.qianjh.microservice.service.impl;

import com.qianjh.microservice.lib.core.exception.ExceptionBuilder;
import com.qianjh.microservice.model.sequence.Sequence;
import com.qianjh.microservice.repository.SequenceRepository;
import com.qianjh.microservice.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author QianJH
 */
@Service
public class SequenceServiceImpl implements SequenceService {

    @Autowired
    private SequenceRepository repository;

    @Override
    public Queue<Long> createIncrementSeq(String seqName) {
        Queue<Long> queue = new LinkedList<>();
        Sequence sequence = repository.findByName(seqName);
        if (sequence == null) {
            ExceptionBuilder.objectNotFoundException("Sequence", "name", seqName);
        }
        for (int i = 1; i <= sequence.getIncrement(); i++) {
            queue.offer(sequence.getCurrentVal() + i);
        }
        sequence.setCurrentVal(sequence.getCurrentVal() + sequence.getIncrement());
        repository.save(sequence);
        return queue;
    }

    @Override
    public Queue<String> createRuleSeq(String seqName) {
        return null;
    }
}
