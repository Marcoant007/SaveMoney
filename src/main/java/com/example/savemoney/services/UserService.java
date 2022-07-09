package com.example.savemoney.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.savemoney.dtos.UserDTO;
import com.example.savemoney.models.users.User;
import com.example.savemoney.repositories.UserRepository;
import com.example.savemoney.services.exceptions.DatabaseException;
import com.example.savemoney.services.exceptions.ServiceNotFoundException;

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

    @Transactional(readOnly = true)
    public UserDTO findUserById(Long id){
        Optional<User> userOp = userRepository.findById(id);
        User userEntity = userOp.orElseThrow(() -> new ServiceNotFoundException("Entity User Not Found"));
        return new UserDTO(userEntity);
    }

    @Transactional
    public UserDTO updatedUser(Long id, UserDTO userDTO){
        try {
            User userEntity = userRepository.getOne(id);
            transformDTOInEntity(userDTO, userEntity);
            userEntity = userRepository.save(userEntity);
            return new UserDTO(userEntity);
        } catch (Exception e) {
            throw new ServiceNotFoundException("Id not found " + id);
        }
    }

    @Transactional
    public void delete(Long id){
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ServiceNotFoundException("Id not found " + id);
        } catch(DataIntegrityViolationException e){
            throw new DatabaseException("Integrity violation");
        }
    }

    public void transformDTOInEntity(UserDTO userDTO, User userEntity){
        userEntity.setName(userDTO.getName());
        userEntity.setCpf(userDTO.getCpf());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setIncome(userDTO.getIncome());
        userEntity.setBirthDate(userDTO.getBirthDate());
    }
}
