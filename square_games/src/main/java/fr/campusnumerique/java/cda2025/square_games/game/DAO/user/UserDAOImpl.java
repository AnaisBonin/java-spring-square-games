package fr.campusnumerique.java.cda2025.square_games.game.DAO.user;

import fr.campusnumerique.java.cda2025.square_games.game.controller.DO.User;
import fr.campusnumerique.java.cda2025.square_games.game.controller.DO.UserImpl;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDAOImpl implements UserDAO {
    private final List<User> usersList = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        return usersList;
    }

    @Override
    public User getUserById(UUID id) {
        return usersList.stream().filter(user -> user.getId() == id).toList().getFirst();
    }

    @Override
    public User addUser(User user) {
        usersList.add(user);

        return user;
    }

    @Override
    public User updateUser(UUID id, User user) {
//        int userIndex = usersList.indexOf();
//
//        usersList.set(userIndex, user);

    return null;
    }

    @Override
    public void deleteUser(UUID id) {
//        User userToDelete = usersList.stream().filter(user -> user.getId() == id).toList().getFirst();
//        usersList.

    }
}
