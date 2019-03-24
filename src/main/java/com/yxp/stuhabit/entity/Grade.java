package com.yxp.stuhabit.entity;

//班级

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    private String gradeName; //年级
    private String classes ; //班级
    private List<TeacherOnserve> headerMasters; // 班主任
    private List<TeacherOnserve> chineseTeachers; // 语文老师
    private List<TeacherOnserve> mathTeachers; // 数学老师
    private List<TeacherOnserve> englishTeachers; // 英语老师
    private List<TeacherOnserve> physicsTeachers; // 物理老师
    private List<TeacherOnserve> chemistryTeachers; // 化学老师
    private List<TeacherOnserve> historyTeachers; // 历史老师
    private List<TeacherOnserve> geographyTeachers; // 地理老师
    private List<TeacherOnserve> biologyTeachers; // 生物老师
    private List<TeacherOnserve> physicalTeachers; // 体育老师
    private List<TeacherOnserve> artTeachers; // 美术老师
    private List<TeacherOnserve> musicTeachers; // 音乐老师
    private List<TeacherOnserve> politicsTeachers; // 政治老师
}
