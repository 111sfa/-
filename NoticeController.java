package com.demo.hotelsystem.controller;

import com.demo.hotelsystem.mapper.NoticeMapper;
import com.demo.hotelsystem.entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/notice")
public class NoticeController {

    @Autowired
    private NoticeMapper noticeMapper;

    @GetMapping("/get")
    public String getNotice() { //提取公告
        try {
            Notice n = noticeMapper.getById(1);
            // 如果数据库查到了就返回内容，没查到就返回默认语
            return (n != null && n.getContent() != null) ? n.getContent() : "欢迎光临！";
        } catch (Exception e) {
            // 后端控制台会打印错误原因，但前端不会崩溃
            e.printStackTrace();
            return "公告加载中...";
        }
    }

    @PostMapping("/update")
    public String updateNotice(@RequestBody Map<String, String> body) {
        if (body.containsKey("content")) {
            String newContent = body.get("content");
            // 执行更新
            int rows = noticeMapper.updateNotice(newContent);
            if (rows > 0) {
                System.out.println("公告更新成功：" + newContent);
                return "success";
            } else {
                System.err.println("公告更新失败，数据库没找到 ID 为 1 的数据");
                return "error";
            }
        }
        return "error";
    }  //更新
}

//处理前端 fetch 发来的公告请求