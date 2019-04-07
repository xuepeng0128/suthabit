package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String userId; // 用户编号
    private String account; // 账号
    private String passWord; // 密码
    private Employee employee; // 员工用户(为空，非员工用户)
    private Teacher teacher;  // 老师用户
    private boolean supperAdmin; // 是否超级管理员
    private boolean schoolAdmin; // 是否学校管理员
    private boolean trainSchoolAdmin; // 是否机构管理员
    private School  manageSchool; // 管理员或老师所在学校
    private TrainSchool  manageTrainSchool; // 管理员或老师所在学校
    private List<Menu> powerMenu;  // 所拥有的权限
}
