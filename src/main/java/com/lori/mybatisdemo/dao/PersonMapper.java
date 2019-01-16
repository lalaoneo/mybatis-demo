package com.lori.mybatisdemo.dao;

import com.lori.mybatisdemo.domain.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper {
    int deleteById(Integer id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectById(Integer id);

    int updateSelective(Person record);

    int update(Person record);
}