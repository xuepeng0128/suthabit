package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "putcard")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PutCard {
    @Id
    private ObjectId id;
    private School school;
    private TrainSchool trainSchool;
    private Circle circle;
    private Habit habit;
    private Date putCardTime;
    private String memo;
    private Student student;
    private List<String> picUrl;
    private List<String> videoUrl;
    private List<String> audioUrl;
}
