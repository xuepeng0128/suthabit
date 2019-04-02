package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subjectexamclass")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectExamClass {
    private String subjectExamClassId;
    private String getSubjectExamClassName;
    private Subject subject;
}
