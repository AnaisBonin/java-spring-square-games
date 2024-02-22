package fr.campusnumerique.java.cda2025.square_games.game.service.game_service;

import fr.campusnumerique.java.cda2025.square_games.game.service.GameCreationParams;
import fr.campusnumerique.java.cda2025.square_games.game.service.game_catalog.GameCatalog;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameCatalog gameCatalog;

    private final Map<String, Game> gamesMap = new HashMap<>();

    @Override
    public Game create(GameCreationParams params) {
        Game game = gameCatalog.createGame(params);
        gamesMap.put(game.getId().toString(), game);
        return game;
    }

    @Override
    public Collection<Game> getAllGames() {
        return gamesMap.values();
    }

    @Override
    public Game getGameById(String gameId) {
        return null;
    }

    @Override
    public Game editGame(String gameId) {

        // jouer un coup check get remaining tokens
        return null;
    }

    @Override
    public void deleteGame(String gameId) {
    }
}
