package fr.campusnumerique.java.cda2025.square_games.game.plugins;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class TicTacToePlugin extends GamePluginImpl {

    @Value("game.tictactoe.default-player-count")
    private String playerCount;

    @Value("game.tictactoe.default-boardsize")
    private String boardsize;

    @Override
    public String getName(Locale locale) {
        return getMessageSource().getMessage("game.tictactoe.factory-id", null, locale);
    }
}
