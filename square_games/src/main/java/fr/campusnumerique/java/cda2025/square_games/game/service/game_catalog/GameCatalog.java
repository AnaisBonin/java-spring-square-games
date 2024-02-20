package fr.campusnumerique.java.cda2025.square_games.game.service.game_catalog;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;

import java.util.Collection;

public interface GameCatalog {
    final TicTacToeGameFactory ticTacToeGameFactory = new TicTacToeGameFactory();
    final ConnectFourGameFactory connectFourGameFactory = new ConnectFourGameFactory();
    final TaquinGameFactory taquinGameFactory = new TaquinGameFactory();

    Collection<GameFactory> getGamesAvailable();
    Game createGame(String gameName);
}
