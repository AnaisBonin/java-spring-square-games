package fr.campusnumerique.java.cda2025.square_games.game.usersjpa.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public UserJpaDTO toJpaDTO() {
        return new UserJpaDTO(this.firstName, this.lastName, this.pseudo);
    }
}
