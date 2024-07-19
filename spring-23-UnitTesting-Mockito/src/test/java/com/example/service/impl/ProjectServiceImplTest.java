package com.example.service.impl;

import com.example.dto.ProjectDTO;
import com.example.entity.Project;
import com.example.mapper.ProjectMapper;
import com.example.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode_test(){

        // *** Given Part ***
        // Defining behaving of our Mock objects
        // if our findByProjectCode is running -> return new Project entity
        when(projectRepository.findByProjectCode(anyString())).thenReturn(new Project()); // Stubbing

        // if we are trying to convert entity to dto -> return new dto object
        when(projectMapper.convertToDto(any(Project.class))).thenReturn(new ProjectDTO());

        // *** When Part ***
        // calling real method to test
        ProjectDTO projectDTO = projectService.getByProjectCode(anyString());

        // *** Then Part ***
        // check order of these 2 mocks
        InOrder inOrder = inOrder(projectRepository, projectMapper);

        // defining in which order these 2 mock should be called
        inOrder.verify(projectRepository).findByProjectCode(anyString());
        inOrder.verify(projectMapper).convertToDto(any(Project.class));

        assertNotNull(projectDTO);

    }

    @Test
    void getByProjectCode_ExceptionTest(){

        // if found empty string -> throw exception
        // behavior
        when(projectRepository.findByProjectCode("")).thenThrow(new NoSuchElementException("Project Not Found"));

        Throwable throwable = assertThrows(NoSuchElementException.class,()->projectService.getByProjectCode(""));

        verify(projectRepository).findByProjectCode("");

        // checking this method -> never run
        verify(projectMapper,never()).convertToDto(any(Project.class));

        assertEquals("Project Not Found", throwable.getMessage());

    }


}