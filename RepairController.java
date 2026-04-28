package com.demo.hotelsystem.controller;

import com.demo.hotelsystem.entity.Repair;
import com.demo.hotelsystem.mapper.RepairMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/repair")
public class RepairController {

    @Autowired
    private RepairMapper repairMapper;

    @GetMapping("/list")
    public List<Repair> getAllRepairs() {  //拉清单
        return repairMapper.findAll();
    }

    @PostMapping("/add")
    public String addRepair(@RequestBody Repair repair) {
        // 如果前端没传 ID，后端生成一个时间戳当 ID  发起报修
        if(repair.getId() == null) repair.setId(System.currentTimeMillis());
        repairMapper.insert(repair);
        return "success";
    }

    @PostMapping("/updateStatus")
    public String updateStatus(@RequestBody Repair repair) {
        repairMapper.updateStatus(repair.getId(), repair.getStatus());
        return "success";
    } //流程转换变更

    @DeleteMapping("/delete/{id}")
    public String deleteRepair(@PathVariable Long id) {
        repairMapper.deleteById(id);
        return "success";
    }
}//删记录