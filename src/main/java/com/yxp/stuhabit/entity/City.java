package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "city")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    private String cityId;
    private String cityname;
    private List<District> districts;
}
