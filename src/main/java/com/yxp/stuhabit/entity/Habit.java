package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "habittemplate")
@Data
@NoArgsConstructor
@AllArgsConstructor
// 标准习惯模板
public class Habit {
  private String  habitId;
  private String habitName;
  private List<Habit> subHabit;

}
