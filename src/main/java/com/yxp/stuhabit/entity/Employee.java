package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private String paperId;
    private String employeeName;
    private String tel;
    private String duty;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date   enterDate;
    private Integer  onDutyState;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  leaveDate;
}
