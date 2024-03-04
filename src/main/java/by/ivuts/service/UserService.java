package by.ivuts.service;

import by.ivuts.dto.UserCreateAndUpdateDto;
import by.ivuts.dto.UserDto;
import by.ivuts.mapper.UserMapper;
import by.ivuts.model.User;
import by.ivuts.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
//@Component
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto findById(Long id) {
        User user = userRepository.findById(id);
        return userMapper.toDto(user);
    }

    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return userMapper.toDto(users);
    }

    public void insert(UserCreateAndUpdateDto dto) {
        User user = userMapper.toEntity(dto);
        userRepository.insert(user);
    }

    public void update(UserCreateAndUpdateDto dto) {
        User user = userMapper.toEntity(dto);
        userRepository.update(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

}
