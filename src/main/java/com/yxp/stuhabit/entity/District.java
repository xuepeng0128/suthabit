package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "district")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class District {
   @Id
   private String  districtId;
   private String  districtName;
   private City city;
}
