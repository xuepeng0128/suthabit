package com.yxp.stuhabit.entity;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Employee {
    @Id
    private String employeeId;
    private String employeeName;
    private String tel;
    private String duty;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date   enterDate;
    private Integer  onDutyState;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  leaveDate;
}
