package hr.markic.service;

import hr.markic.domain.User;
import hr.markic.dto.UserDTO;

import java.util.List;
import java.util.Optional;

/**
 * User service interface.
 */
public interface UserService {

    /**
     * Retrieves the list of all {@link User} entities.
     * @return
     */
    List<User> findAllUsers();

    /**
     * Retrieves one {@link User} instance by id.
     * @param userId
     * @return
     */
    Optional<User> findOne(Long userId);

    /**
     * Retrieves one {@link User} instance by userName.
     * @param userName
     * @return
     */
    Optional<User> findOneByUsername(String userName);

    /**
     * First registration of a user and its contacts within the DB.
     * @param user
     * @return
     */
    UserDTO saveUser(UserDTO user);

    /**
     * Removed user by id.
     * @param userId
     */
    void deleteUser(Long userId);

}
