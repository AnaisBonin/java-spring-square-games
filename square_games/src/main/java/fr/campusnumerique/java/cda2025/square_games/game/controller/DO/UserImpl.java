package fr.campusnumerique.java.cda2025.square_games.game.controller.DO;

import java.util.UUID;

public class UserImpl implements User {
    private final UUID id;
    private String userName;
    private String fullName;

    public UserImpl(String userName, String fullName) {
        this.id = UUID.randomUUID();
        this.userName = userName;
        this.fullName = fullName;
    }

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
};
