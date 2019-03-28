package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trainschoolstyle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainSchoolStyle {
    @Id
    private String trainSchoolStyleId;
    private String trainSchoolStyleName;
}
