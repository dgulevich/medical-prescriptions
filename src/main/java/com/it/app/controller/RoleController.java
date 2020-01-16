package com.it.app.controller;

import com.it.app.dto.request.RoleRequestDto;
import com.it.app.dto.response.RoleResponseDto;
import com.it.app.dto.response.UserResponseDto;
import com.it.app.model.Role;
import com.it.app.model.User;
import com.it.app.service.RoleService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private Mapper mapper;

    private RoleService roleService;

    public RoleController(Mapper mapper, RoleService roleService) {
        this.mapper = mapper;
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<RoleResponseDto>> getAll() {
        final List<Role> roles = roleService.findAll();
        final List<RoleResponseDto> roleDtoList = roles.stream()
                .map((role) -> mapper.map(role, RoleResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(roleDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDto> getOne(@PathVariable Long id) {
        final RoleResponseDto roleDto = mapper.map(roleService.findById(id), RoleResponseDto.class);
        return new ResponseEntity<>(roleDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleResponseDto> save(@Valid @RequestBody RoleRequestDto roleRequestDto) {
        roleRequestDto.setId(null);
        final RoleResponseDto responseRoleDto = mapper.map(roleService.save(mapper.map(roleRequestDto, Role.class)), RoleResponseDto.class);
        return new ResponseEntity<>(responseRoleDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponseDto> update(@Valid @RequestBody RoleRequestDto roleRequestDto, @PathVariable Long id) {
        if (!Objects.equals(id, roleRequestDto.getId())) {
            throw new RuntimeException("Url param id is not equals to roleId!");
        }
        final RoleResponseDto responseRoleDto = mapper.map(roleService.update(mapper.map(roleRequestDto, Role.class)), RoleResponseDto.class);
        return new ResponseEntity<>(responseRoleDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        roleService.deleteById(id);
    }
}
