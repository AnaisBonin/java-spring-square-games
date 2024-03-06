package fr.campusnumerique.java.cda2025.square_games.game.myDAO.service.game_service;

import fr.campusnumerique.java.cda2025.square_games.game.myDAO.controller.DTO.GameDTO;
import fr.campusnumerique.java.cda2025.square_games.game.myDAO.controller.DO.GameCreationParams;
import fr.le_campus_numerique.square_games.engine.Game;

import java.util.Collection;
import java.util.Locale;

public interface GameService {
    GameDTO create(GameCreationParams params);

    String getLocalName(Locale locale);

    Collection<GameDTO> getAllGames();

    Game getGameById(String gameId);

    Game editGame(String gameId);

    void deleteGame(String gameId);
}
