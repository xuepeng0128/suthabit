package com.yxp.stuhabit.entity;

import com.mongodb.lang.Nullable;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

// 入学
public class StartSchool {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    private School school; // 所入学校
    private Grade grades; // 班级
    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
}
