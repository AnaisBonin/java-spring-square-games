package fr.campusnumerique.java.cda2025.square_games.game.usersjpa;

import fr.campusnumerique.java.cda2025.square_games.game.controller.DTO.UserDTO;
import fr.campusnumerique.java.cda2025.square_games.game.usersjpa.entities.User;
import fr.campusnumerique.java.cda2025.square_games.game.usersjpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam UserDTO userDTO) {
        User n = new User();
        n.setFirstName(userDTO.firstName());
        n.setLastName(userDTO.lastName());
        n.setPseudo(userDTO.pseudo());
        userRepository.save(n);

        return "Saved new user with pseudo: " + userDTO.pseudo();
    }

    @GetMapping(path="/users")
    public List<UserDTO> getUsers() {
        List<UserDTO> allUsersDTO = new ArrayList<>();

        Iterable<User> allUsers = userRepository.findAll();

        while(allUsers.iterator().hasNext()) {
            User user = allUsers.iterator().next();
            allUsersDTO.add(user.toDTO());
        }

        return allUsersDTO;
    }


}
