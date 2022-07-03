package com.example.savemoney.services;

import java.util.List;

import javax.management.ServiceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public Page<UserDTO> listAllUsers(PageRequest pageRequest){
        Page<User> usersList = userRepository.findAll(pageRequest);
        Page<UserDTO> userDTO = usersList.map(userObject -> new UserDTO(userObject));
        return userDTO;
    }



    public void transformDTOInEntity(UserDTO userDTO, User userEntity){
        userEntity.setName(userDTO.getName());
        userEntity.setCpf(userDTO.getCpf());
        userEntity.setIncome(userDTO.getIncome());
        userEntity.setBirthDate(userDTO.getBirthDate());
        userEntity.setPassword(userDTO.getPassword());
    }
}
