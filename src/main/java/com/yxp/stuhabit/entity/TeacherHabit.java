package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

// 学校机构老师创建的习惯
@Document(collection = "teacherhabit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherHabit {
    @Id
    private ObjectId id;
    private List<String> circleIds; // 所属圈子
    private Teacher teacher; // 创建习惯的任职老师
    private Habit habit;  // 创建的习惯
    private boolean alljoin; // 是否圈子全员参加
    private int guodoubi; // 打卡所得果豆币
    private Date beginDate; // 习惯开始时间
    private Date endDate; // 习惯结束时间
    private List<Student> joinStudents; // 参加的学生
}
