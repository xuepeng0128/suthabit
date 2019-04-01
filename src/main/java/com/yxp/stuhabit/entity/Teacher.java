package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teacher")
@Data
@NoArgsConstructor
@AllArgsConstructor

@CompoundIndexes({
        @CompoundIndex(name = "teacher_idx", def = "{'paperId': 1, 'teacherName':1 , 'onserve.school.schoolName' :1}")
})
public class Teacher {
    @Id
    private String paperId; // 身份证
    private String tel; // 电话
    private String teacherName; // 老师姓名
    private TeacherDuty teacherDuty; // 当前职务
    private TeacherOnserve onserve; // 当前任教
}
