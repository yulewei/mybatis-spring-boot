package com.example.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 通用 DAO 基类
 *
 * @author yulewei on 2017/8/24
 */
public interface IBaseDAO<T, E> {

    long countByExample(E example);

    int deleteByExample(E example);

    int deleteByPrimaryKey(Serializable id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(E example);

    T selectByPrimaryKey(Serializable id);

    int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

    int updateByExample(@Param("record") T record, @Param("example") E example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
