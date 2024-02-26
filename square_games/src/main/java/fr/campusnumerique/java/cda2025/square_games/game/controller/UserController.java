package fr.campusnumerique.java.cda2025.square_games.game.controller;

import fr.campusnumerique.java.cda2025.square_games.game.DAO.user.UserDAO;
import fr.campusnumerique.java.cda2025.square_games.game.controller.DO.User;
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

    @GetMapping("/users")
    public List<UserDTO> getUsers(){
        return userDAO.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public UserDTO getUserById(@PathVariable UUID userId){
        return userDAO.getUserById(userId);
    }

    @GetMapping("users?{isConnected}")
    public Collection<User> getConnectedUsers(@PathVariable boolean isConnected) {
        return null;
    }

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userDAO.addUser(userDTO);
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
