package com.demo.hotelsystem.mapper;

import com.demo.hotelsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE username = #{username} AND password = #{password} LIMIT 1")
    User login(String username, String password);
}