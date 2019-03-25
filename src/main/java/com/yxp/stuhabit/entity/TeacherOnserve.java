package com.yxp.stuhabit.entity;

import com.mongodb.lang.Nullable;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

// 老师任教
public class TeacherOnserve {
    @Id
    private ObjectId _id;
    private School school; // 任教学校
    private int grade;  // 年纪
    private int classes;// 班级
    private Teacher teacher; // 任教老师
    private Rank rank; // 职务
    private Date endDate; // 任教结束日期
}
