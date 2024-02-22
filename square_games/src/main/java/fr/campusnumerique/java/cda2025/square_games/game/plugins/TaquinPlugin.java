package fr.campusnumerique.java.cda2025.square_games.game.plugins;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class TaquinPlugin extends GamePluginImpl {

    @Value("game.taquin.default-player-count")
    private int playerCount;

    @Value("game.taquin.default-boardsize")
    private int boardsize;

    @Override
    public String getName(Locale locale) {
        return getMessageSource().getMessage("game.taquin.factory-id", null, locale);
    }
}
