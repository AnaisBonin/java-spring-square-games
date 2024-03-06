package fr.campusnumerique.java.cda2025.square_games.game.myDAO.controller;

import fr.campusnumerique.java.cda2025.square_games.game.myDAO.controller.DTO.GameDTO;
import fr.campusnumerique.java.cda2025.square_games.game.myDAO.controller.DO.GameCreationParams;
import fr.campusnumerique.java.cda2025.square_games.game.myDAO.service.game_catalog.GameCatalog;
import fr.campusnumerique.java.cda2025.square_games.game.myDAO.service.game_service.GameService;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Locale;

@RestController
public class GameController {
    @Autowired
    private GameCatalog gameCatalog;

    @Autowired
    private GameService gameService;

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
}
