package fr.campusnumerique.java.cda2025.square_games.game.plugins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public abstract class GamePluginImpl implements GamePlugin {
    @Autowired
    MessageSource messageSource;

    public MessageSource getMessageSource() {
        return messageSource;
    }
}
