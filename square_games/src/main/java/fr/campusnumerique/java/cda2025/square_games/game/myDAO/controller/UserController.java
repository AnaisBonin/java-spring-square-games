package fr.campusnumerique.java.cda2025.square_games.game.myDAO.controller;

import fr.campusnumerique.java.cda2025.square_games.game.myDAO.user.UserDAO;
import fr.campusnumerique.java.cda2025.square_games.game.myDAO.controller.DO.User;
import fr.campusnumerique.java.cda2025.square_games.game.myDAO.controller.DO.UserImpl;
import fr.campusnumerique.java.cda2025.square_games.game.myDAO.controller.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDAO userDAO;

    private UserDTO transformIntoUserDTO(User user) {
        return new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getPseudo());
    }

    private User transformIntoUser(UserDTO userDTO) {
        return new UserImpl(userDTO.id(), userDTO.firstName(), userDTO.lastName(), userDTO.pseudo());
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers(){
        List<User> usersList = userDAO.getAllUsers();

        return usersList.stream().map(this::transformIntoUserDTO).toList();
    }

    @GetMapping("/users/{userId}")
    public UserDTO getUserById(@PathVariable int userId){
        User user = userDAO.getUserById(userId);
        return transformIntoUserDTO(user);
    }

    @GetMapping("users?{isConnected}")
    public Collection<User> getConnectedUsers(@PathVariable boolean isConnected) {
        return null;
    }

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        User user = userDAO.addUser(transformIntoUser(userDTO));
        return transformIntoUserDTO(user);
    }

    @PutMapping("/users/{userId}")
    public Object updateUser(@PathVariable int userId, @RequestBody UserDTO userDTO) {
        User user = userDAO.updateUser(userId, transformIntoUser(userDTO));
        return transformIntoUserDTO(user);
    }

    @DeleteMapping("/users/{userId}")
    public Object deleteUser(@PathVariable int userId) {
        return userDAO.deleteUser(userId);
    }

}
