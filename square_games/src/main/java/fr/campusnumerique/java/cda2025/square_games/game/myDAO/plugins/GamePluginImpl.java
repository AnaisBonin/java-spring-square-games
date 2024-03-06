package fr.campusnumerique.java.cda2025.square_games.game.myDAO.plugins;

import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public abstract class GamePluginImpl implements GamePlugin {

    private final GameFactory gameFactory;
    private int playerCount;
    private int boardSize;

    @Autowired
    MessageSource messageSource;

    public GamePluginImpl(GameFactory gameFactory) {
        this.gameFactory = gameFactory;
    }

    public GameFactory getGameFactory() {
        return gameFactory;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }
}
