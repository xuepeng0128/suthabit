package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "habit")
@Data
@NoArgsConstructor
@AllArgsConstructor
// 标准习惯模板
public class Habit {
  @Id
  private String  habitId;
  private String habitName;
  private List<Habit> subHabit;
  private Employee employee;
  private Teacher principalPublisher;
  private Teacher teacherPublisher;
  private Student studentPublisher; // 家长发布
  private Date beginDate;
  private Date endDate;



}
