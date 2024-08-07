package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.*;  // statically imported method from Mockito

@ExtendWith(MockitoExtension.class) // adding mockito to framework
class UserServiceImplTest {

    @Mock
    UserRepository userRepository; // creating mock object

    @Mock
    UserMapper userMapper;

    @InjectMocks
    UserServiceImpl userService; // in testing we are using directly class not interface

    @Test
    void findByUserName_Test(){

        // this step is calling real method inside main, which wil be tested
        userService.findByUserName("harold@manager.com");

        // checking if this method is run or not
        verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com",false);

        verify(userRepository,times(1)).findByUserNameAndIsDeleted("harold@manager.com",false);

        verify(userRepository,atLeastOnce()).findByUserNameAndIsDeleted("harold@manager.com",false);

        verify(userRepository,atLeast(1)).findByUserNameAndIsDeleted("harold@manager.com",false);

        //can be 0 or 1 as example
        verify(userRepository,atMostOnce()).findByUserNameAndIsDeleted("harold@manager.com",false);

        verify(userRepository, atMost(10)).findByUserNameAndIsDeleted("harold@manager.com",false);

        InOrder inOrder = inOrder(userRepository,userMapper);
        inOrder.verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com",false);
        inOrder.verify(userMapper).convertToDto(null);


    }


}