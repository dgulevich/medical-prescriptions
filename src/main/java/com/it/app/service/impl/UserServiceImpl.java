package com.it.app.service.impl;

import com.it.app.component.Validation;
import com.it.app.model.User;
import com.it.app.repository.UserRepository;
import com.it.app.service.RoleService;
import com.it.app.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * The type User service.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private RoleService roleService;

    private Validation validation;

    /**
     * Instantiates a new User service.
     *
     * @param userRepository the user repository
     * @param validation     the validation
     */
    public UserServiceImpl(UserRepository userRepository, Validation validation) {
        this.userRepository = userRepository;
        this.validation = validation;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not exist"));
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User save(User user) {
        validation.validate(user.getId() != null, "Transient User must not have an ID");
        validation.validate(userRepository.existsByName(user.getName()), "User name is not unique");
        return saveAndFlush(user);
    }

    @Override
    public User update(User user) {
        final Long id = user.getId();
        validation.validate(id == null, "User must have an ID");
        final User duplicateUser = userRepository.findByName(user.getName());
        final boolean isDuplicateExist = duplicateUser != null && !Objects.equals(id, duplicateUser.getId());
        validation.validate(isDuplicateExist, "User name is not unique!");
        return saveAndFlush(user);
    }

    @Override
    public void delete(User user) {
        final Long id = user.getId();
        validation.validate(id == null,"Persistent User must have an ID");
        findById(id);
        userRepository.delete(user);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }

    private User saveAndFlush(User user) {
        user.getRoles().forEach(role -> {
            validation.validate(role == null || role.getId() == null, "User roles is null!");
            role.setName(roleService.findById(role.getId()).getName());
        });
        return userRepository.saveAndFlush(user);
    }

}