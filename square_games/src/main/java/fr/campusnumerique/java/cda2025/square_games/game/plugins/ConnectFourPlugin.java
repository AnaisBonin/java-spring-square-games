package fr.campusnumerique.java.cda2025.square_games.game.plugins;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class ConnectFourPlugin extends GamePluginImpl {

    @Value("game.connect4.default-player-count")
    private int playerCount;

    @Value("game.connect4.default-boardsize")
    private int boardsize;

    @Override
    public String getName(Locale locale) {
        return getMessageSource().getMessage("game.connect4.factory-id", null, locale);
    }
}
