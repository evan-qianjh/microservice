package com.qianjh.microservice.model.sequence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author QianJH
 */
@Data
@Entity
public class Sequence {
    @Id
    private Long id;
    private String name;
    private Long currentVal;
    private Long increment;
    private Long maxVal;
    private String rule;
    private String desc;
}
