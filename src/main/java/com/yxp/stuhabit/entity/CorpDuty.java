package com.yxp.stuhabit.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "corpduty")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CorpDuty {
    @Id
    public String corpDutyId;
    public String corpDutyName;
    public String supDutyId;

}
