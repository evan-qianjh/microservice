package com.qianjh.microservice.model.sequence.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author QianJH
 * @date 2017/11/14
 */
@Data
@Entity
public class Sequence implements Serializable{
    @Id
    private Long id;
    private String nameEn;
    private String nameCn;
    private Long currentValue;
    private Long maxValue;
    private String rule;
    private Integer increment;
    private String description;
}
