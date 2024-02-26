package fr.campusnumerique.java.cda2025.square_games.game.DAO.user;

import fr.campusnumerique.java.cda2025.square_games.game.DbAccess;
import fr.campusnumerique.java.cda2025.square_games.game.controller.DO.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDAOImpl implements UserDAO {
    private DbAccess dbAccess;

    private final List<User> usersList = new ArrayList<>();

    public UserDAOImpl() {
        dbAccess = DbAccess.getInstance();
    }

    private int getUserIndex(UUID userId) {
        int indexUser = -1;
        for (int i = 0; i < usersList.toArray().length; i++) {
            if (usersList.get(i).getId().equals(userId)) {
                indexUser = i;
            }
        }
        return indexUser;
    }

    @Override
    public List<User> getAllUsers() {
        return usersList;
    }

    @Override
    public User getUserById(UUID id) {
        int userIndex = getUserIndex(id);
        return usersList.get(userIndex);
    }

    @Override
    public User addUser(User user) {
        usersList.add(user);
        return user;
    }

    @Override
    public User updateUser(UUID id, User user) {
        int userIndex = getUserIndex(id);

        if (userIndex == -1) {
            return null;
        } else {
            usersList.set(userIndex, user);

            return user;
        }
    }

    @Override
    public User deleteUser(UUID id) {
        int userIndex = getUserIndex(id);
        User user = getUserById(id);
        usersList.remove(userIndex);

        System.out.println("User " + id + " deleted");
        return user;
    }
}
