package com.ibm.ro.tm.apprenticeship.poll.metter.dto;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Answer;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;

import java.util.Set;

public class UserDTO {
    private Long id;
    private String name;
    private String role;

    private String login;

    private String password;

    public UserDTO() {
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login){
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }




}
