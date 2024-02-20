package fr.campusnumerique.java.cda2025.square_games.game;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;

import java.util.Collection;

public interface GameService {
Game create(String gameName);
Collection<Game> getAllGames();
Game editGame();
void deleteGame();
}
