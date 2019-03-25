package com.yxp.stuhabit.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

// 学校机构创建的习惯
public class TeacherHabit {
    @Id
    private ObjectId _id;
    private SchoolCircle schoolCircle; // 所属圈子
    private TeacherOnserve onserveTeacher; // 创建习惯的任职老师
    private Habit habit;  // 创建的习惯
    private boolean Alljoin; // 是否圈子全员参加
    private int guodoubi; // 完成所得果豆币
    private Date beginDate; // 习惯开始时间
    private Date endDate; // 习惯结束时间
    private List<Student> joinStudents; // 参加的学生
}
