package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//班级


@Document(collection = "classes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classes {
    @Id
    private ObjectId id;
    private int grade;  // 年纪 学籍 2013 级
    private int classes;// 班级
    private School school; // 所属学校
    private List<Student> students; // 班级学生
}
