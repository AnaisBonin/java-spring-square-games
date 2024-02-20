package fr.campusnumerique.java.cda2025.square_games.game;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class GameServiceImpl implements GameService {

    TicTacToeGameFactory ticTacToeGameFactory = new TicTacToeGameFactory();
    ConnectFourGameFactory connectFourGameFactory = new ConnectFourGameFactory();
    TaquinGameFactory taquinGameFactory = new TaquinGameFactory();

    // sert à stocker les jeux créés
    private final Map<String, Game> gameMap = new HashMap<>();

    @Override
    public Game create(String gameName) {
       Game game = switch (gameName) {
            case "TicTacToe" -> ticTacToeGameFactory.createGame(2, 9);

            case "Connect Four" -> connectFourGameFactory.createGame(2, 7);

            case "Taquin" -> taquinGameFactory.createGame(2, 10);

            default -> throw new IllegalArgumentException("bad game creation");
        };

       gameMap.put(game.getId().toString(), game);
       return game;
    }

    @Override
    public Collection<Game> getAllGames() {
        return gameMap.values();
    }

    @Override
    public Game editGame() {
        return null;
    }

    @Override
    public void deleteGame() {
    }
}
