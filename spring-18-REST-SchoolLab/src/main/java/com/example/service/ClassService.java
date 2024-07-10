package com.example.service;

import com.example.dto.ClassDTO;

import java.util.List;

public interface ClassService {

    List<ClassDTO> findAll();

    ClassDTO findById(Long id) throws Exception;

}