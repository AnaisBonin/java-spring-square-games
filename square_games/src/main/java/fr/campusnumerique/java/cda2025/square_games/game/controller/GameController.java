package fr.campusnumerique.java.cda2025.square_games.game.controller;

import fr.campusnumerique.java.cda2025.square_games.game.DAO.user.UserDAO;
import fr.campusnumerique.java.cda2025.square_games.game.controller.DO.User;
import fr.campusnumerique.java.cda2025.square_games.game.controller.DTO.GameDTO;
import fr.campusnumerique.java.cda2025.square_games.game.controller.DTO.UserDTO;
import fr.campusnumerique.java.cda2025.square_games.game.service.game_catalog.GameCatalog;
import fr.campusnumerique.java.cda2025.square_games.game.controller.DO.GameCreationParams;
import fr.campusnumerique.java.cda2025.square_games.game.service.game_service.GameService;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@RestController
public class GameController {
    @Autowired
    private GameCatalog gameCatalog;

    @Autowired
    private GameService gameService;

    @Autowired UserDAO userDAO;

    @GetMapping("/local_name")
    public String getTest(@RequestHeader("Accept-Language") Locale locale) {
        return gameService.getLocalName(locale);
    }

    @GetMapping("/game_catalog")
    public Collection<GameFactory> getGameCatalog(){
        return gameCatalog.getGamesAvailable();
    };

    @GetMapping("/games")
    public Collection<GameDTO> getGames(){
        return gameService.getAllGames();
    };

    @PostMapping("/games")
    public GameDTO createGame(@RequestBody GameCreationParams params) {
        return gameService.create(params);
    }

    @GetMapping("/games/{gameId}")
    public Object getGame(@PathVariable String gameId) {
        //TODO - actually get and return game witd id 'gameId'
        return null;
    }

    @PutMapping("/games/{gameId}")
    public Object updateGame(@PathVariable String gameId) {
        //TODO update game with id 'gameId'
        return null;
    }

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
