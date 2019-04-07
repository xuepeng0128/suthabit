package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subjectexamclass")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectExamClass {
    @Id
    private String subjectExamClassId;
    private String subjectExamClassName;
    private StudySubject studySubject;
}
