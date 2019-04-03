package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "circle")
@Data
@NoArgsConstructor
@AllArgsConstructor
// 圈子
public class Circle {
   @Id
   private ObjectId circleId;
   @Indexed
   private String  circleName;
   private School school;
   private TrainSchool trainSchool;
   private Teacher buildMan; // 创建人
   private Date buildDate; // 创建日期
   private List<Teacher> teachers ;// 圈内老师
   private List<Student> students; // 圈内学生
   private Date endDate; // 圈子关闭时间
   private String closeReason ; // 关闭原因
   private String closeMan ; // 关闭人
}
