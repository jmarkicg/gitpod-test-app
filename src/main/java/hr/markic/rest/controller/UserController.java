package hr.markic.rest.controller;

import hr.markic.domain.User;
import hr.markic.dto.UserDTO;
import hr.markic.mapper.UserMapper;
import hr.markic.rest.exception.InvalidRequestDataException;
import hr.markic.rest.exception.UnknownUserException;
import hr.markic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    private UserService userService;

    private UserMapper userMapper;

    @Autowired
    UserController(UserService userService,
                   UserMapper userMapper){
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = userService.findAllUsers();

        List<UserDTO> userDTOS = users.stream().
                map(user -> userMapper.toDTO(user)).collect(Collectors.toList());

        return ResponseEntity.ok().body(userDTOS);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long userId) throws UnknownUserException {
        Optional<User> user = userService.findOne(userId);

        if(!user.isPresent()){
            throw new UnknownUserException(userId);
        }

        return ResponseEntity.ok().body(userMapper.toDTO(user.get()));
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) throws UnknownUserException {
        Optional<User> user = userService.findOne(userId);

        if(!user.isPresent()){
            throw new UnknownUserException(userId);
        }

        userService.deleteUser(userId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/user")
    public ResponseEntity saveUser(@RequestBody UserDTO user)
            throws InvalidRequestDataException, URISyntaxException {
        if (Objects.isNull(user)){
            throw new InvalidRequestDataException();
        }
        user = userService.saveUser(user);
        return ResponseEntity.ok().body(user);
    }

}


