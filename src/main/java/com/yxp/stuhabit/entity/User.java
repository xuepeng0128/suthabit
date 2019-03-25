package com.yxp.stuhabit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String account; // 账号
    private String passWord; // 密码
    private Employee employee; // 员工用户(为空，非员工用户)
    private Teacher teacher;  // 老师用户
    private boolean isSupperAdmin; // 是否超级管理员
    private boolean isAdmin; // 是否学校，机构管理员
    private School  manageSchool; // 管理员或老师所在学校
}
