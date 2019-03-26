package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

// 教师职务表
@Document(collection = "rank")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rank {
    @Id
    private String rankId;
    private String rankName;
    private List<Rank> subRank;
}
