package com.demo.hotelsystem.entity;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Room {
    private Integer id;
    private String roomNumber;
    private String type;
    private String status;
    private Double price;
    // --- 新增这三个字段 ---
    private String customerName;
    private String customerPhone;
    private String customerIdCard;
    private Long checkInTime;
    // ... 这里保留你原来的 Getter 和 Setter 方法 ...
    // 注意：如果是用 IDEA，按 Alt+Insert 选 Getter and Setter 把这三个新字段加上
}