package hr.markic.service.impl;

import hr.markic.domain.User;
import hr.markic.dto.UserDTO;
import hr.markic.mapper.UserMapper;
import hr.markic.repository.UserRepository;
import hr.markic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findOne(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<User> findOneByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public UserDTO saveUser(UserDTO userDto) {
        User user = userMapper.toEntity(userDto);
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
