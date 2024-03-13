package by.ivuts.service;

import by.ivuts.dto.UserCreateAndUpdateDto;
import by.ivuts.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto findById(Long id);

    List<UserDto> findAll();

    void insert(UserCreateAndUpdateDto dto);

    void update(Long id, UserCreateAndUpdateDto dto);

    void delete(Long id);

}
