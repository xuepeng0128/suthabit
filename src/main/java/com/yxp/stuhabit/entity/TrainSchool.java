package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trainschool")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainSchool {
    @Id
    private String trainSchoolId; // 培训学校编号
    private String trainSchoolName; // 培训学校名称
    private TrainSchoolStyle trainSchoolStyle;
    private City city; // 市
    private District district; // 区
    private float longitude; // 经度坐标
    private float latitude ; // 纬度坐标
    private String address; // 地址
    private Employee saleMans; // 业务员
}
