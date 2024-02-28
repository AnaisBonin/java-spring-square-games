package fr.campusnumerique.java.cda2025.square_games.game.DAO.user;

import fr.campusnumerique.java.cda2025.square_games.game.DbAccess;
import fr.campusnumerique.java.cda2025.square_games.game.controller.DO.User;
import fr.campusnumerique.java.cda2025.square_games.game.controller.DO.UserImpl;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

@Service
public class UserDAOImpl implements UserDAO {
    private final DbAccess dbAccess;

    private final List<User> usersList = new ArrayList<>();

    public UserDAOImpl() {
        dbAccess = DbAccess.getInstance();
    }

    private int getUserIndex(int userId) {
        int indexUser = -1;
        for (int i = 0; i < usersList.toArray().length; i++) {
            if (usersList.get(i).getId() == userId) {
                indexUser = i;
            }
        }
        return indexUser;
    }

    private User createUserWithSQLRes(ResultSet res) throws SQLException {
        int id = res.getInt(1);
        String firstName = res.getString(2);
        String lastName = res.getString(3);
        String pseudo = res.getString(4);

        return new UserImpl(id, firstName, lastName, pseudo);
    }

    @Override
    public List<User> getAllUsers() {
        String query = "SELECT * FROM users;";

        List<User> usersList = new ArrayList<>();

        try {
            Statement statement = dbAccess.getConnection().createStatement();
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                User user = createUserWithSQLRes(res);
                usersList.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

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
    public User updateUser(int id, User user) {
        int userIndex = getUserIndex(id);

        if (userIndex == -1) {
            return null;
        } else {
            usersList.set(userIndex, user);

            return user;
        }
    }

    @Override
    public User deleteUser(int id) {
        int userIndex = getUserIndex(id);
        User user = getUserById(id);
        usersList.remove(userIndex);

        System.out.println("User " + id + " deleted");
        return user;
    }
}
