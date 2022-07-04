package com.example.savemoney.controllers;

import java.net.URI;
import java.security.Provider.Service;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.savemoney.dtos.UserDTO;
import com.example.savemoney.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
        @RequestParam(value = "direction", defaultValue = "ASC") String direction,
        @RequestParam(value = "orderBy", defaultValue = "name") String orderBy){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        Page<UserDTO> userList = userService.listAllUsers(pageRequest);
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long id){
        UserDTO userDTO = userService.findUserById(id);
        return ResponseEntity.ok().body(userDTO);
    }
    
    @PostMapping()
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        userDTO = userService.createUser(userDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(userDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> updatedUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        userDTO = userService.updatedUser(id, userDTO);
        return ResponseEntity.ok().body(userDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleted(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
