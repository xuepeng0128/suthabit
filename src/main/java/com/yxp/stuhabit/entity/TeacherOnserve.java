package com.yxp.stuhabit.entity;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

// 老师任教

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherOnserve {
    private School school; // 任教学校
    private Integer grade;  // 年纪
    private Integer classes;// 班级
    private TeacherDuty teacherDuty; // 职务
}
