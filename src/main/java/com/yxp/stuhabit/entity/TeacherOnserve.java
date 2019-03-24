package com.yxp.stuhabit.entity;

import com.mongodb.lang.Nullable;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

// 任教
public class TeacherOnserve {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate; //任教开始日期
    private Teacher teacher; // 任教老师
    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate; // 任教结束日期
}
