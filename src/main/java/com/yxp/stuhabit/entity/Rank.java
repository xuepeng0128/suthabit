package com.yxp.stuhabit.entity;

import org.springframework.data.annotation.Id;

import java.util.List;

// 教师职务表
public class Rank {
    @Id
    private String rankId;
    private String rankName;
    private List<Rank> subRank;
}
