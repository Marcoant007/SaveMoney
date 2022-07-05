package com.example.savemoney.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.savemoney.controllers.exceptions.FieldMessage;
import com.example.savemoney.dtos.UserInsertDTO;
import com.example.savemoney.models.users.User;
import com.example.savemoney.repositories.UserRepository;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UserInsertValid ann){}

    @Override
    public boolean isValid(UserInsertDTO userDTO, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();
        User user = userRepository.findByEmail(userDTO.getEmail());

        if(user != null){
            list.add(new FieldMessage("email", "Email já existe"));
        }

        for(FieldMessage e : list){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMesage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
        }

        return list.isEmpty();
    }
}
