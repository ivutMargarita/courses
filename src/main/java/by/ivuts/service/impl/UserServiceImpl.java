package by.ivuts.service.impl;

import by.ivuts.dto.UserCreateAndUpdateDto;
import by.ivuts.dto.UserDto;
import by.ivuts.exception.ServiceException;
import by.ivuts.mapper.UserMapper;
import by.ivuts.model.User;
import by.ivuts.repository.UserRepository;
import by.ivuts.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto findById(Long id) {
        try {
            User user = userRepository.findById(id);
            return userMapper.toDto(user);
        } catch (Exception exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    public List<UserDto> findAll() {
        try {
            List<User> users = userRepository.findAll();
            return userMapper.toDto(users);
        } catch (Exception exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    public void insert(UserCreateAndUpdateDto dto) {
        try {
            User user = userMapper.toEntity(dto);
            userRepository.insert(user);
        } catch (Exception exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    public void update(Long id, UserCreateAndUpdateDto dto) {
        try {
            User user = userMapper.toEntity(dto);
            user.setId(id);
            userRepository.update(user);
        } catch (Exception exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            userRepository.delete(id);
        } catch (Exception exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

}
