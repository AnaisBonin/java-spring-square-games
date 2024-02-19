package fr.campusnumerique.java.cda2025.square_games.game;

import fr.campusnumerique.java.cda2025.square_games.game.users.UserCreationParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
public class GameController {
    @Autowired
    private GameCatalog gameCatalog;

    @GetMapping("/game_catalog")
    public Collection<String> getGameCatalog(){
        return gameCatalog.getGameIdentifiers();
    };

    @PostMapping("/games")
    public String createGame(@RequestBody GameCreationParams params) {
        // TODO create a new game
        return UUID.randomUUID().toString();
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
    public Collection<UserCreationParams> getUsers(){
        return null;
    }

    @GetMapping("/users/{userId}")
    public UserCreationParams getUser(@PathVariable String userId){
        return null;
    }

    @GetMapping("users?{isConnected}")
    public Collection<UserCreationParams> getConnectedUsers(@PathVariable boolean isConnected) {
        return null;
    }

    @PostMapping("/users")
    public Object createUser(@RequestBody UserCreationParams userCreationParams) {
        // TODO create a new user
        return UUID.randomUUID().toString();
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
