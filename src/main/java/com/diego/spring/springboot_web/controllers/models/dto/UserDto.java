package com.diego.spring.springboot_web.controllers.models.dto;

import com.diego.spring.springboot_web.controllers.models.User;

public class UserDto {

    private String title;
    private User user;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }    

}
