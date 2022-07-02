package com.example.savemoney.dtos;

import java.io.Serializable;
import java.time.Instant;

import com.example.savemoney.models.users.User;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private String cpf;
    private Double income;
    private Instant birthDate;
    private String password;

  
    public UserDTO(User userEntity) {
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.cpf = userEntity.getCpf();
        this.income = userEntity.getIncome();
        this.birthDate = userEntity.getBirthDate();
        this.password = userEntity.getPassword();
    }


    public UserDTO() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return this.income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Instant getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
