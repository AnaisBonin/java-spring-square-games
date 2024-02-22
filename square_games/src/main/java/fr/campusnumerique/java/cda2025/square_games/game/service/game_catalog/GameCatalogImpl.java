package fr.campusnumerique.java.cda2025.square_games.game.service.game_catalog;

import fr.campusnumerique.java.cda2025.square_games.game.service.GameCreationParams;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class GameCatalogImpl implements GameCatalog {

    @Override
    public Collection<GameFactory> getGamesAvailable() {
        List<GameFactory> availableGames = new ArrayList<GameFactory>();

        availableGames.add(ticTacToeGameFactory);
        availableGames.add(connectFourGameFactory);
        availableGames.add(taquinGameFactory);

        return availableGames;
    }

    @Override
    public Game createGame(GameCreationParams params) {
        return switch (params.getGameType()) {
            case "tictactoe" -> ticTacToeGameFactory.createGame(2, 9);

            case "connect4" -> connectFourGameFactory.createGame(2, 7);

            case "puzzle 15" -> taquinGameFactory.createGame(2, 10);

            default -> throw new IllegalArgumentException("bad game creation");
        };
    }
}
