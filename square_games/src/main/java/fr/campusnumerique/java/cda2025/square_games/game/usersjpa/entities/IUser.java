package fr.campusnumerique.java.cda2025.square_games.game.usersjpa.entities;

public interface IUser {
    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getPseudo();

    void setPseudo(String pseudo);

    void setId(int id);

    int getId();

    UserJpaDTO toJpaDTO();
}
