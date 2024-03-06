package fr.campusnumerique.java.cda2025.square_games.game.myDAO.user;

import fr.campusnumerique.java.cda2025.square_games.game.DbAccess;
import fr.campusnumerique.java.cda2025.square_games.game.myDAO.controller.DO.User;
import fr.campusnumerique.java.cda2025.square_games.game.myDAO.controller.DO.UserImpl;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
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
    public User getUserById(int id) {
        String query = "SELECT * FROM users WHERE id=?;";

        try {
            PreparedStatement preparedStatement = dbAccess.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet res = preparedStatement.executeQuery();

            res.next();
            return createUserWithSQLRes(res);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public int getId (String pseudo) {
        String query = "SELECT id FROM users WHERE pseudo=?;";

        try {
            PreparedStatement preparedStatement = dbAccess.getConnection().prepareStatement(query);
            preparedStatement.setString(1, pseudo);

            ResultSet res = preparedStatement.executeQuery();

            res.next();
            return res.getInt(1);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }

    private void updateUserId(User user) {
        int userId = getId(user.getPseudo());
        user.setId(userId);
    }

    @Override
    public User addUser(User user) {
        String query = "INSERT INTO users (firstname, lastname, pseudo) VALUES(?, ?, ?);";

        try {
            PreparedStatement preparedStatement = dbAccess.getConnection().prepareStatement(query);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPseudo());

            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("Created user - query affected: " + affectedRows + " rows");

            updateUserId(user);

            return user;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public User updateUser(int id, User user) {
        String query = "UPDATE users SET firstName = ?, lastName = ?, pseudo = ? WHERE id = ?;";

        try {
            PreparedStatement preparedStatement = dbAccess.getConnection().prepareStatement(query);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPseudo());
            preparedStatement.setInt(4, id);


            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("Created user - query affected: " + affectedRows + " rows");

            updateUserId(user);

            return user;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public String deleteUser(int id) {
        String query = "DELETE FROM users WHERE id = ?;";
        String deletionMessage = "error";

        try {
            PreparedStatement preparedStatement = dbAccess.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);

            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("Created user - query affected: " + affectedRows + " rows");

            deletionMessage = "User " + id + " deleted";

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return deletionMessage;
    }
}
