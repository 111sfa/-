package com.demo.hotelsystem.mapper;

import com.demo.hotelsystem.entity.Repair;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface RepairMapper {

    @Select("SELECT * FROM repair ORDER BY id DESC")
    List<Repair> findAll();

    // 注意：这里的字段名必须和你数据库 repair 表的列名一模一样
    @Insert("INSERT INTO repair(id, room_id, category, description, status) " +
            "VALUES(#{id}, #{roomId}, #{category}, #{description}, #{status})")
    void insert(Repair repair);

    @Update("UPDATE repair SET status = #{status} WHERE id = #{id}")
    void updateStatus(@Param("id") Long id, @Param("status") Integer status);

    @Delete("DELETE FROM repair WHERE id = #{id}")
    void deleteById(Long id);
}