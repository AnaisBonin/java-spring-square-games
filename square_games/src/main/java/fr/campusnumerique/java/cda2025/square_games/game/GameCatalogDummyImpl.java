package fr.campusnumerique.java.cda2025.square_games.game;

import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class GameCatalogDummyImpl implements GameCatalog {
    TicTacToeGameFactory ticTacToeGameFactory = new fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory();

    @Override
    public Collection<String> getGameIdentifiers() {
        return Collections.singleton(ticTacToeGameFactory.getGameId());
    }
}
