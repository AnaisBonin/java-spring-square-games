package fr.campusnumerique.java.cda2025.square_games.game.usersjpa.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User implements IUser {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String pseudo;

    public User() {
    }

    public User(UserJpaDTO userJpaDTO) {
        this.firstName = userJpaDTO.firstName();
        this.lastName = userJpaDTO.lastName();
        this.pseudo = userJpaDTO.lastName();
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

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public UserJpaDTO toJpaDTO() {
        return new UserJpaDTO(this.firstName, this.lastName, this.pseudo);
    }
}
