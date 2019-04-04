package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "parenthabit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParentHabit {
    @Id
    private ObjectId id;
    private String circleIds; // 所属圈子
    private Student student; // 创建习惯的学生
    private Habit habit;  // 创建的习惯
    private Date beginDate; // 习惯开始时间
    private Date endDate; // 习惯结束时间
    private Student joinStudent; // 参加的学生

}
