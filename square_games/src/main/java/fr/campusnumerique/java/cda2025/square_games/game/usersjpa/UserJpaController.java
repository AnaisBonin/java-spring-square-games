package fr.campusnumerique.java.cda2025.square_games.game.usersjpa;

import fr.campusnumerique.java.cda2025.square_games.game.usersjpa.entities.User;
import fr.campusnumerique.java.cda2025.square_games.game.usersjpa.entities.UserJpaDTO;
import fr.campusnumerique.java.cda2025.square_games.game.usersjpa.repositories.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user-jpa")
public class UserJpaController {
    @Autowired
    private UserRepository userRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(UserJpaDTO.class);

    @PostMapping(path = "/users")
    public UserJpaDTO addNewUser(@RequestBody UserJpaDTO userJpaDTO) {
        User user = new User(userJpaDTO);
        userRepository.save(user);

        LOGGER.info("Added new user");
        return user.toJpaDTO();
    }

    @GetMapping(path = "/users")
    public List<UserJpaDTO> getUsers() {
        List<UserJpaDTO> allUsersDTO = new ArrayList<>();
        Iterable<User> allUsers = userRepository.findAll();

        for (User user : allUsers) {
            allUsersDTO.add(user.toJpaDTO());
        }

        return allUsersDTO;
    }

    @GetMapping("/users/{userId}")
    public UserJpaDTO getUserById(@PathVariable Integer userId) throws Exception {

        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return user.toJpaDTO();
        } else {
            LOGGER.error("Error while getting user");
            throw new Exception();
        }
    }

    @PutMapping("/users/{userId}")
    public UserJpaDTO updateUser(@PathVariable int userId, @RequestBody UserJpaDTO userJpaDTO) throws Exception {
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            user.setFirstName(userJpaDTO.firstName());
            user.setLastName(userJpaDTO.lastName());
            user.setPseudo(userJpaDTO.pseudo());
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
