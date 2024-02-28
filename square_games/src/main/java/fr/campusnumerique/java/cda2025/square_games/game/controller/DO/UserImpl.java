package fr.campusnumerique.java.cda2025.square_games.game.controller.DO;

import java.util.UUID;

public class UserImpl implements User {
    private final UUID id;
    private String firstName;
    private String lastName;
    private String pseudo;

    public UserImpl(String firstName, String lastName, String pseudo) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.pseudo = pseudo;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
       public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getPseudo() {
        return pseudo;
    }

    @Override
     public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
};
