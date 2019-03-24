package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Document(collection = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
   private String  studentId;
   private String studentName;
   private String sex;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date birthday;
   private String paperId;
   private List<StartSchool> startSchoolHis ;  // 入学历史
}
