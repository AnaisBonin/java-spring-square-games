package fr.campusnumerique.java.cda2025.square_games.game.controller.DO;

import java.util.UUID;

public interface User {
    UUID getId();
    String getFirstName();
    void setFirstName(String firstName);
    String getLastName();
    void setLastName(String lastName);
    String getPseudo();
    void setPseudo(String pseudo);
}
