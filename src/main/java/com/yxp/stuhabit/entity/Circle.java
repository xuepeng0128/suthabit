package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "circle")
@Data
@NoArgsConstructor
@AllArgsConstructor
// 圈子模板
public class Circle {
   @Id
   private String  circleTemplateId;
   private String  circleTemplateName;
   private Habit Habits;
}
