package fr.campusnumerique.java.cda2025.square_games.game.DAO.user;

import org.apache.catalina.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
}

