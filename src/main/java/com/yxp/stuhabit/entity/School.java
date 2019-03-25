package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "school")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class School {
    @Id
    private String schoolId; // 学校编号
    private String schoolName; // 学校名称
    private City city; // 市
    private District district; // 区
    private float longitude; // 经度坐标
    private float latitude ; // 纬度坐标
    private String address; // 地址
    private List<Grade> grades;  // 当前班级
    private List<Employee> saleMans; // 业务员
}
