package fr.campusnumerique.java.cda2025.square_games.game.myDAO.plugins;

import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.context.MessageSource;

import java.util.Locale;

public interface GamePlugin {
    GameFactory getGameFactory();
    MessageSource getMessageSource();
    String getName(Locale locale);
}
