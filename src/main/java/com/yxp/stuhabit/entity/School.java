package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "school")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class School {
    @Id
    private String schoolId;
    private String schoolName;
    private City city;
    private District district;
    private float longitude;
    private float latitude ;
    private String address;
    private List<Grade> grades;
}
