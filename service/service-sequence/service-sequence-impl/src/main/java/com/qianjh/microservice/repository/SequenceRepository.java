package com.qianjh.microservice.repository;

import com.qianjh.microservice.model.sequence.domain.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;

/**
 * @author QianJH
 * @date 2017/11/14
 */
public interface SequenceRepository extends JpaRepository<Sequence, Long> {

    /**
     * 根据主键查询，并且行级锁
     *
     * @param id
     * @return
     */
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Query(value = "select t from TbSequence t where t.id = :id")
    Sequence findOneForUpdate(@Param("id") Long id);
}
