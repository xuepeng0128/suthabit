package com.yxp.stuhabit.entity;

import com.mongodb.lang.Nullable;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

// 老师任教

@Data
public class TeacherOnserve {
    private School school; // 任教学校
    private int grade;  // 年纪
    private int classes;// 班级
    private Rank rank; // 职务
}
