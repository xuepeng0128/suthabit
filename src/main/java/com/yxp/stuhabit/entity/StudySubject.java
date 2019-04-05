package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subject")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudySubject {
    @Id
    private String studySubjectId;
    private String studySubjectName;
    private String  habitClass ;

}
