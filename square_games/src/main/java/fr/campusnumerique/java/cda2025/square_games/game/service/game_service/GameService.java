package fr.campusnumerique.java.cda2025.square_games.game.service.game_service;

import fr.campusnumerique.java.cda2025.square_games.game.controller.GameDTO;
import fr.campusnumerique.java.cda2025.square_games.game.service.GameCreationParams;
import fr.le_campus_numerique.square_games.engine.Game;

import java.util.Collection;

public interface GameService {
    GameDTO create(GameCreationParams params);

    Collection<GameDTO> getAllGames();

    Game getGameById(String gameId);

    Game editGame(String gameId);

    void deleteGame(String gameId);
}
