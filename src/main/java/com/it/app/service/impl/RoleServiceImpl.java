package com.it.app.service.impl;

import com.it.app.component.Validation;
import com.it.app.model.Role;
import com.it.app.repository.RoleRepository;
import com.it.app.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    private Validation validation;

    public RoleServiceImpl(RoleRepository roleRepository, Validation validation) {
        this.roleRepository = roleRepository;
        this.validation = validation;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role does not exist!"));
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Role save(Role role) {
        validation.validate(role.getId() != null, "Transient Role must not have an ID");
        validation.validate(roleRepository.existsByName(role.getName()), "Role name is not unique");
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public Role update(Role role) {
        final Long id = role.getId();
        validation.validate(id == null, "Role must have an ID");
        final Role duplicateRole = roleRepository.findByName(role.getName());
        findById(id);
        final boolean isDuplicateExist = duplicateRole != null && !Objects.equals(id, duplicateRole.getId());
        validation.validate(isDuplicateExist, "Role name is not unique!");
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public void delete(Role role) {
        final Long id = role.getId();
        validation.validate(id == null, "Persistent Role must have an ID");
        roleRepository.delete(role);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        roleRepository.deleteById(id);
    }
}