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

}
