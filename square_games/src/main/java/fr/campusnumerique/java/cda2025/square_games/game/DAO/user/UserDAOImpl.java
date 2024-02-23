package fr.campusnumerique.java.cda2025.square_games.game.DAO.user;

import fr.campusnumerique.java.cda2025.square_games.game.controller.DO.User;
import fr.campusnumerique.java.cda2025.square_games.game.controller.DTO.UserDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class UserDAOImpl implements UserDAO {
    private final Map<String, UserDTO> usersMap = new HashMap<>();

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserById(UUID id) {
        return null;
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User updateUser(UUID id) {
        return null;
    }

    @Override
    public void deleteUser(UUID id) {

    }
}
