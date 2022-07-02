package com.example.savemoney.services;

import javax.management.ServiceNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.savemoney.dtos.UserDTO;
import com.example.savemoney.models.users.User;
import com.example.savemoney.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserDTO createUser(UserDTO userDTO){
            User userEntity = new User();
            transformDTOInEntity(userDTO, userEntity);
            userEntity = userRepository.save(userEntity);
            return new UserDTO(userEntity);
    }



    public void transformDTOInEntity(UserDTO userDTO, User userEntity){
        userEntity.setName(userDTO.getName());
        userEntity.setCpf(userDTO.getCpf());
        userEntity.setIncome(userDTO.getIncome());
        userEntity.setBirthDate(userDTO.getBirthDate());
        userEntity.setPassword(userDTO.getPassword());
    }
}
