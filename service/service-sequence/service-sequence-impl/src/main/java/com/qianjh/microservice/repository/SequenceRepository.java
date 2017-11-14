package com.qianjh.microservice.repository;

import com.qianjh.microservice.model.sequence.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author QianJH
 */
public interface SequenceRepository extends JpaRepository<Sequence, Long> {
    /**
     * 根据名称查询
     * @param name
     * @return
     */
    Sequence findByName(String name);
}
