package fr.campusnumerique.java.cda2025.square_games.game.myDAO.plugins;

import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class TaquinPlugin extends GamePluginImpl {

    @Value("game.taquin.default-player-count")
    private String playerCount;

    @Value("game.taquin.default-boardsize")
    private String boardsize;

    public TaquinPlugin() {
        super(new TaquinGameFactory());
    }

    @Override
    public String getName(Locale locale) {
        return getMessageSource().getMessage("game.taquin.factory-id", null, locale);
    }
}
