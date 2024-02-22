package fr.campusnumerique.java.cda2025.square_games.game.service.game_service;

import fr.campusnumerique.java.cda2025.square_games.game.service.GameCreationParams;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;

import java.util.Collection;

public interface GameService {
    Game create(GameCreationParams params);

    Collection<Game> getAllGames();

    Game getGameById(String gameId);

    Game editGame(String gameId);

    void deleteGame(String gameId);
}
