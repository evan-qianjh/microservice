package com.qianjh.microservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;

/**
 * @author QianJH
 */
@Slf4j
@RestController
@RequestMapping("/sequence")
public class SequenceController {

    public Queue<Long> createIncrementSeq(String seqName) {

    }
}
