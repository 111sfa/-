package com.demo.hotelsystem.mapper;

import com.demo.hotelsystem.entity.Staff;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface StaffMapper {

    @Select("SELECT id, name, position, phone, work_id AS workId, username, password FROM staff")
    List<Staff> findAll();

    // 关键点：这里要确保把新的 username 和 password 存进去
    @Insert("INSERT INTO staff(name, position, phone, work_id, username, password) " +
            "VALUES(#{name}, #{position}, #{phone}, #{workId}, #{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Staff staff);

    // 关键点：登录就靠这个查询，必须包含新的字段
    @Select("SELECT id, name, position, phone, work_id AS workId, username, password " +
            "FROM staff WHERE username = #{username} LIMIT 1")
    Staff findByUsername(String username);

    @Delete("DELETE FROM staff WHERE id = #{id}")
    int deleteById(Long id);
}