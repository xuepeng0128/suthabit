package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "circle")
@Data
@NoArgsConstructor
@AllArgsConstructor
// 学校圈子模板
public class SchoolCircle {
   @Id
   private String  circleId;
   private String  circleName;
   private Teacher buildMan; // 创建人
   private Date buildDate; // 创建日期
   private List<Teacher> teachers ;// 圈内老师
   private List<Student> students; // 圈内学生
   private Date endDate; // 圈子关闭时间
   private String CloseReason ; // 关闭原因
}
