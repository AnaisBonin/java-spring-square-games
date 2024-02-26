package fr.campusnumerique.java.cda2025.square_games.game.DAO.user;

import fr.campusnumerique.java.cda2025.square_games.game.controller.DO.User;

import java.util.List;
import java.util.UUID;

public interface UserDAO {
    List<User> getAllUsers();

    User getUserById(UUID id);

    User addUser(User user);

    User updateUser(UUID id, User user);

    void deleteUser(UUID id);
}

