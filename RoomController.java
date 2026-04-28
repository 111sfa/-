package com.demo.hotelsystem.controller;

import com.demo.hotelsystem.entity.Room;
import com.demo.hotelsystem.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping; // 记得导入 PostMapping
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomMapper roomMapper;

    @GetMapping
    public List<Room> getRooms() {
        return roomMapper.findAll();
    }

    // 新增这个方法：处理前端点“预订”按钮的动作
    @PostMapping("/updateStatus")
    public String updateRoomStatus(@RequestBody Map<String, Object> params) {
        // 这样写能把前端传来的姓名、电话、时间戳全都接住
        roomMapper.updateStatus(params);
        return "success";
    }
}