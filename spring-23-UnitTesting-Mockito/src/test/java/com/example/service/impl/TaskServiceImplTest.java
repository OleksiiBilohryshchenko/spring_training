package com.example.service.impl;

import com.example.dto.TaskDTO;
import com.example.entity.Task;
import com.example.mapper.TaskMapper;
import com.example.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    TaskRepository taskRepository;

    @Mock
    TaskMapper taskMapper;

    @InjectMocks
    TaskServiceImpl taskService;

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L})
    void findById_Test(long id){

        // Given part (Preparation)
        Task task = new Task();

        when(taskRepository.findById(id)).thenReturn(Optional.of(task)); // Optional<Task>
        when(taskMapper.convertToDto(task)).thenReturn(new TaskDTO());

        // When (Action is happening)
        taskService.findById(id);

        // Then (Assertions and verification checks)
        verify(taskRepository).findById(id);
        verify(taskMapper).convertToDto(task);

    }

    // BDD Format
    @Test
    void findById_BDD_Test(){
        // Given
        Task task = new Task();
        // same with lines when() above
        given(taskRepository.findById(anyLong())).willReturn(Optional.of(task));
        given(taskMapper.convertToDto(task)).willReturn(new TaskDTO());

        //When
        taskService.findById(anyLong());

        //Then
        then(taskRepository).should().findById(anyLong());
        then(taskMapper).should(atLeastOnce()).convertToDto(task);

    }

}