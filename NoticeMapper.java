package com.demo.hotelsystem.mapper;

import com.demo.hotelsystem.entity.Notice;
import org.apache.ibatis.annotations.*;

@Mapper
public interface NoticeMapper {

    // 1. 这里的字段名必须是 id
    @Select("SELECT id, content FROM notices WHERE id = 1")
    Notice getById(Integer id);

    // 2. 更新时也必须匹配字段名 id
    @Update("UPDATE notices SET content = #{content} WHERE id = 1")
    int updateNotice(String content);
}