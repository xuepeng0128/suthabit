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
// 圈子模板
public class Circle {
   @Id
   private String  circleId;
   private String  circleName;
   private List<Habit> Habits;   // 本圈子内习惯集合
   private Teacher buildMan; // 创建人
   private Date buildDate; // 创建日期
   private List<Teacher> teachers ;// 圈内老师
   private List<Student> students; // 圈内学生

}
