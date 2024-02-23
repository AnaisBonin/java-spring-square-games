package fr.campusnumerique.java.cda2025.square_games.game.controller.DO;

import org.apache.catalina.Role;

import java.util.UUID;

public class User {
    private final UUID id;
    private String userName;
    private String fullName;
    private Role role;

    public User(String userName, String fullName, Role role) {
        this.id = UUID.randomUUID();
        this.userName = userName;
        this.fullName = fullName;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
};
