package com.example.service;

import com.example.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getUsers();

    UserDTO create(UserDTO userDTO);

}
