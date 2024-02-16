package fr.campusnumerique.java.cda2025.square_games.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class GameController {
    @Autowired
    private GameCatalog gameCatalog;

    @GetMapping("/game_catalog")
    public Collection<String> getGameCatalog(){
        return gameCatalog.getGameIdentifiers();
    };


}
