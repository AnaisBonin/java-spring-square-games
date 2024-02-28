package fr.campusnumerique.java.cda2025.square_games.game.controller.DO;

public class UserImpl implements User {
    private int id;
    private String firstName;
    private String lastName;
    private String pseudo;

    public UserImpl(int id, String firstName, String lastName, String pseudo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pseudo = pseudo;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
