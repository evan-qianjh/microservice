package com.qianjh.microservice.lib.mybatis.mapper;

import java.util.List;
import java.util.Map;

/**
 * @author QianJH
 * @date 2017/10/16
 */
public interface BaseMapper<T> {

    /**
     * 查询列表
     *
     * @param param
     * @return
     */
    List<T> find(Map<String, Object> param);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * 统计
     *
     * @param param
     * @return
     */
    Integer count(Map<String, Object> param);

    /**
     * 保存
     *
     * @param entity
     * @return
     */
    Integer save(T entity);

    /**
     * 保存多个
     *
     * @param entities
     * @return
     */
    Integer save(List<T> entities);

    /**
     * 更新
     *
     * @param entity
     * @return
     */
    Integer update(T entity);

    /**
     * 根据ID删除
     *
     * @param id
     * @return
     */
    Integer delete(Long id);

    /**
     * 删除ID列表删除
     *
     * @param ids
     * @return
     */
    Integer delete(Long[] ids);

}
