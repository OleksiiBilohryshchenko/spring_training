package com.example.service.impl;

import com.example.dto.RoleDTO;
import com.example.entity.Role;
import com.example.mapper.MapperUtil;
import com.example.mapper.RoleMapper;
import com.example.repository.RoleRepository;
import com.example.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    private final MapperUtil mapperUtil;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper, MapperUtil mapperUtil) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<RoleDTO> listAllRoles() {
        List<Role> roleList = roleRepository.findAll();
//        return roleList.stream().map(roleMapper::convertToDto).collect(Collectors.toList());
        return roleList.stream().map(role -> mapperUtil.convert(role, new RoleDTO())).collect(Collectors.toList());
//        return roleList.stream().map(role -> mapperUtil.convert(role, RoleDTO.class)).collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(Long id) {




        return roleMapper.convertToDto(roleRepository.findById(id).get());
    }
}
