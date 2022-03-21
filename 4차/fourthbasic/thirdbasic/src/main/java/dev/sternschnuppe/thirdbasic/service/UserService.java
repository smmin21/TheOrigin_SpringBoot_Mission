package dev.sternschnuppe.thirdbasic.service;

import dev.sternschnuppe.thirdbasic.boundary.model.UserDto;

import java.util.Collection;

public interface UserService {
    UserDto create(UserDto dto);
    UserDto read(Long id);
    Collection<UserDto> readAll();
    boolean update(Long id, UserDto dto);
    boolean delete(Long id);
}