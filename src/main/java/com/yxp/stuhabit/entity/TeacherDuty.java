package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teacherduty")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDuty {
    @Id
    public String teacherDutyId;
    public String teacherDutyName;
    public boolean master;
}
