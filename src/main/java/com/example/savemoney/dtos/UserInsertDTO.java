package com.example.savemoney.dtos;

public class UserInsertDTO extends UserDTO{
    private static final Long serialVersionUID = 1L;

    private String password;

    public UserInsertDTO() {
        super();
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
