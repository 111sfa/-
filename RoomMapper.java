package com.demo.hotelsystem.mapper;

import com.demo.hotelsystem.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
import java.util.Map; // 就是漏掉了这一行！

@Mapper
public interface RoomMapper {

    @Select("SELECT * FROM rooms")
    List<Room> findAll();

    // 这一段 SQL 必须和数据库字段完全对应，才能存入客户信息和时间
    @Update("UPDATE rooms SET status=#{status}, " +
            "customer_name=#{customerName}, " +
            "customer_phone=#{customerPhone}, " +
            "customer_id_card=#{customerIdCard}, " +
            "check_in_time=#{checkInTime} WHERE id=#{id}")
    void updateStatus(Map<String, Object> params);
}