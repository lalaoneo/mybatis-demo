package com.lori.mybatisdemo.dao;

import com.lori.mybatisdemo.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteById(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectById(Integer id);

    int updateSelective(User record);

    int update(User record);
}
