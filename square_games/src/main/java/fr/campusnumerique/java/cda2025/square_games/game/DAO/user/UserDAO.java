package fr.campusnumerique.java.cda2025.square_games.game.DAO.user;

import fr.campusnumerique.java.cda2025.square_games.game.controller.DO.User;

import java.util.List;
import java.util.UUID;

public interface UserDAO {
    public List<User> getAllUsers();
    public User getUserById(UUID id);
    public User addUser(User user);
    public User updateUser(UUID id);
    public void deleteUser(UUID id);
}

