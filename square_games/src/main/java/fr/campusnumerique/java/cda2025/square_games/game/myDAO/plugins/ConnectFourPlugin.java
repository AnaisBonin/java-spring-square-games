package fr.campusnumerique.java.cda2025.square_games.game.myDAO.plugins;

import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class ConnectFourPlugin extends GamePluginImpl {

    @Value("game.connect4.default-player-count")
    private String playerCount;

    @Value("game.connect4.default-boardsize")
    private String boardsize;

    public ConnectFourPlugin() {
        super(new ConnectFourGameFactory());
    }

    @Override
    public String getName(Locale locale) {
        return getMessageSource().getMessage("game.connect4.factory-id", null, locale);
    }
}
