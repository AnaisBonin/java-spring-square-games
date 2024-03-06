package fr.campusnumerique.java.cda2025.square_games.game.myDAO.user;

import fr.campusnumerique.java.cda2025.square_games.game.myDAO.controller.DO.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    User getUserById(int id);

    User addUser(User user);

    User updateUser(int id, User user);

    String deleteUser(int id);
}

