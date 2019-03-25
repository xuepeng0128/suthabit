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
  private String habitId;
  private String habitName;
  private String beloneHabitClass ; // (1,德2.智3.体4.美5.劳)
  private String memo ; // 文本描述
  private String vedioUrl ; // 视频
  private String audioUrl ; // 音频

}
