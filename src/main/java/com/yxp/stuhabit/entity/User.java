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
    private String account;
    private String passWord;
    private Employee employee;
    private Teacher teacher;
    private Student student;
    private boolean isSupperAdmin;
    private boolean isAdmin;
}
