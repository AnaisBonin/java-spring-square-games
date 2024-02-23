package fr.campusnumerique.java.cda2025.square_games.game.DAO.user;

import fr.campusnumerique.java.cda2025.square_games.game.controller.DO.User;
import fr.campusnumerique.java.cda2025.square_games.game.controller.DO.UserImpl;
import fr.campusnumerique.java.cda2025.square_games.game.controller.DTO.UserDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDAOImpl implements UserDAO {
    private final List<User> usersList = new ArrayList<>();

    private UserDTO createUserDTO(User user) {
        return new UserDTO(user.getUserName(), user.getFullName());
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return usersList.stream().map(this::createUserDTO).toList();
    }

    @Override
    public UserDTO getUserById(UUID id) {
        User userById = usersList.stream().filter(user -> user.getId() == id).toList().getFirst();
        return createUserDTO(userById);
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User createdUser = new UserImpl(userDTO.userName(), userDTO.fullName());
        usersList.add(createdUser);

        return createUserDTO(createdUser);
    }

    @Override
    public UserDTO updateUser(UUID id) {
        return null;
    }

    @Override
    public void deleteUser(UUID id) {
//        UserDTO userToDelete = usersList.stream().filter(user -> user.getId() == id).toList().getFirst();
//        usersList.

    }
}
