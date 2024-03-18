package fr.campusnumerique.java.cda2025.square_games.game.usersjpa.controllers;

import fr.campusnumerique.java.cda2025.square_games.game.usersjpa.entities.AuthenticationDTO;
import fr.campusnumerique.java.cda2025.square_games.game.usersjpa.entities.User;
import fr.campusnumerique.java.cda2025.square_games.game.usersjpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/public")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
private    AuthenticationManager authenticationManager;


    private String hashPassword(String userPassword) {
        return passwordEncoder.encode(userPassword);
    }


    @GetMapping(path = "/login")
    public String login(@RequestBody AuthenticationDTO authenticationDTO) {
        String hashedPass = hashPassword(authenticationDTO.password());
         User user = userRepository.findByUsername(authenticationDTO.username());

        System.out.println("LOOOGGGGIIIIN");
        if (user != null) {
            System.out.println("USER FOUNDED");

        } else {
            System.out.println("USER NOT FOUND");
        }


    return hashedPass;
    }

    @GetMapping
    public String publicTest() {
        return "Coucou public";
    }

}
