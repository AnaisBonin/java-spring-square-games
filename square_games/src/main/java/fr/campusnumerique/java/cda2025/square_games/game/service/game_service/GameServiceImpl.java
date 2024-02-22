package fr.campusnumerique.java.cda2025.square_games.game.service.game_service;

import fr.campusnumerique.java.cda2025.square_games.game.controller.GameDTO;
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

    private final Map<String, GameDTO> gamesMap = new HashMap<>();

    @Override
    public GameDTO create(GameCreationParams params) {
        Game game = gameCatalog.createGame(params);
        GameDTO gameDTO = new GameDTO(game.getFactoryId(), game.getBoardSize(), 2);
        gamesMap.put(game.getId().toString(), gameDTO);

        return gameDTO;
    }

    @Override
    public Collection<GameDTO> getAllGames() {
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
