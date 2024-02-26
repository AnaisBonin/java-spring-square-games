package fr.campusnumerique.java.cda2025.square_games.game.controller;

import fr.campusnumerique.java.cda2025.square_games.game.DAO.user.UserDAO;
import fr.campusnumerique.java.cda2025.square_games.game.controller.DO.User;
import fr.campusnumerique.java.cda2025.square_games.game.controller.DO.UserImpl;
import fr.campusnumerique.java.cda2025.square_games.game.controller.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    UserDAO userDAO;

    private UserDTO transformIntoUserDTO(User user) {
        return new UserDTO(user.getId(), user.getUserName(), user.getFullName());
    }

    private User transformIntoUser(UserDTO userDTO) {
        return new UserImpl(userDTO.userName(), userDTO.fullName());
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers(){
        List<User> userList = userDAO.getAllUsers();
        return null;
    }

    @GetMapping("/users/{userId}")
    public UserDTO getUserById(@PathVariable UUID userId){
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
    public Object updateUser(@PathVariable String userId) {
        //TODO update user with id 'userId'
        return null;
    }

    @DeleteMapping("/users/{userId}")
    public Object deleteUser(@PathVariable String userId) {
        //TODO delete user with id 'userId'
        return null;
    }

}
