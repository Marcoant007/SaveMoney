package com.example.savemoney.dtos;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.savemoney.models.users.User;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;

    @Size(min = 5, max = 60, message = "O nome deve conter no minimo 5 caracteres e no máximo 60")
    @NotBlank(message = "Campo requerido")
    private String name;

    @NotBlank(message = "Campo obrigatório")
    private String cpf;
    
    private Double income;

    @Email(message = "Favor colocar um email válido")
    private String email;

    private Instant birthDate;

    Set<RoleDTO> roles = new HashSet<>();
    

    public UserDTO(long id, String name, String cpf, Double income, String email, Instant birthDate, Set<RoleDTO> roles) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.email = email;
        this.birthDate = birthDate;
        this.roles = roles;
    }
  
    public UserDTO(User userEntity) {
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.cpf = userEntity.getCpf();
        this.email = userEntity.getEmail();
        this.income = userEntity.getIncome();
        this.birthDate = userEntity.getBirthDate();
        userEntity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Set<RoleDTO> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }
}
