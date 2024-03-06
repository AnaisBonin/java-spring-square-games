package fr.campusnumerique.java.cda2025.square_games.game.usersjpa.controllers;

import fr.campusnumerique.java.cda2025.square_games.game.usersjpa.entities.User;
import fr.campusnumerique.java.cda2025.square_games.game.usersjpa.entities.createUserDTO;

import fr.campusnumerique.java.cda2025.square_games.game.usersjpa.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user-jpa")
public class UserJpaController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final Logger LOGGER = LoggerFactory.getLogger(createUserDTO.class);

    private String hashPassword(String userPassword) {
        return passwordEncoder.encode(userPassword);
    }
    @PostMapping(path = "/users")
    public createUserDTO addNewUser(@RequestBody createUserDTO createUserDTO) {
        String hashedPass = hashPassword(createUserDTO.password());

        User user = new User(createUserDTO, hashedPass);
        userRepository.save(user);

        LOGGER.info("Added new user");
        return user.toJpaDTO();
    }

    @GetMapping(path = "/users")
    public List<createUserDTO> getUsers() {
        List<createUserDTO> allUsersDTO = new ArrayList<>();
        Iterable<User> allUsers = userRepository.findAll();

        for (User user : allUsers) {
            allUsersDTO.add(user.toJpaDTO());
        }

        return allUsersDTO;
    }

    @GetMapping("/users/{userId}")
    public createUserDTO getUserById(@PathVariable Integer userId) throws Exception {

        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return user.toJpaDTO();
        } else {
            LOGGER.error("Error while getting user");
            throw new Exception();
        }
    }

    @GetMapping("users/username/{username}")
    public createUserDTO getUserByPseudo(@PathVariable String username) {
        User user = userRepository.findByUsername(username);

        return user.toJpaDTO();
    }

    @GetMapping("/users/username/{username}/id")
    public int getUserKeyByUsername(@PathVariable String username) {
        User user = userRepository.findByUsername(username);

        return user.getId();
    }

    @PutMapping("/users/{userId}")
    public createUserDTO updateUser(@PathVariable int userId, @RequestBody createUserDTO createUserDTO) throws Exception {
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            user.setFirstName(createUserDTO.firstName());
            user.setLastName(createUserDTO.lastName());
            user.setUsername(createUserDTO.username());
            user.setPassword(hashPassword(createUserDTO.password()));
            userRepository.save(user);
            return user.toJpaDTO();
        } else {
            throw new Exception();
        }
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {
        userRepository.deleteById(userId);
        return "User " + userId + " deleted";
    }
}
