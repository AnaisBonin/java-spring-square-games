package fr.campusnumerique.java.cda2025.square_games.game.usersjpa;

import fr.campusnumerique.java.cda2025.square_games.game.controller.DTO.UserDTO;
import fr.campusnumerique.java.cda2025.square_games.game.usersjpa.entities.User;
import fr.campusnumerique.java.cda2025.square_games.game.usersjpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user-jpa")
public class UserJpaController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/users")
    public @ResponseBody String addNewUser(@RequestParam UserDTO userDTO) {
        User user = new User(userDTO);
        userRepository.save(user);

        return "Saved new user with pseudo: " + userDTO.pseudo();
    }

    @GetMapping(path = "/users")
    public List<UserDTO> getUsers() {
        List<UserDTO> allUsersDTO = new ArrayList<>();

        Iterable<User> allUsers = userRepository.findAll();

        if(allUsers != null){
            while (allUsers.iterator().hasNext()) {
                User user = allUsers.iterator().next();
                allUsersDTO.add(user.toDTO());
            }
        }

        return allUsersDTO;
    }

    @GetMapping("/users/{userId}")
    public UserDTO getUserById(@PathVariable Integer userId) throws Exception {

        User user = userRepository.findById(userId).orElse(null);
        if(user != null) {
            return user.toDTO();
        } else {
            throw new Exception();
        }
    }

    @PutMapping("/users/{userId}")
    public UserDTO updateUser(@PathVariable int userId, @RequestBody UserDTO userDTO) throws Exception {
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            user.setFirstName(userDTO.firstName());
            user.setLastName(userDTO.lastName());
            user.setPseudo(userDTO.pseudo());
            userRepository.save(user);
            return user.toDTO();
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
