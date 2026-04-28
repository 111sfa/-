package com.demo.hotelsystem.controller;

import com.demo.hotelsystem.entity.Staff;
import com.demo.hotelsystem.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffMapper staffMapper;

    @GetMapping("/list")
    public List<Staff> getAllStaff() {
        return staffMapper.findAll();
    }  //员工名册

    @PostMapping("/add")
    public String addStaff(@RequestBody Staff staff) {  //入职
        staffMapper.insert(staff);
        return "success";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        // 去数据库找这个用户
        Staff staff = staffMapper.findByUsername(username);

        if (staff != null && staff.getPassword().equals(password)) {
            return "success";
        }
        return "fail";
    }

    @DeleteMapping("/delete/{id}") // 对应前端的辞退逻辑
    public String deleteStaff(@PathVariable Long id) {
        staffMapper.deleteById(id);
        return "success";
    }
}