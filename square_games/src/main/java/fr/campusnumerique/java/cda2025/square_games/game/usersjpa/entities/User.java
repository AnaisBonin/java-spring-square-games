package fr.campusnumerique.java.cda2025.square_games.game.usersjpa.entities;

import fr.campusnumerique.java.cda2025.square_games.game.controller.DTO.UserDTO;
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

    public User(UserDTO userDTO) {
        this.id = userDTO.id();
        this.firstName = userDTO.firstName();
        this.lastName = userDTO.lastName();
        this.pseudo = userDTO.lastName();
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

    public UserDTO toDTO() {
        return new UserDTO(this.id, this.firstName, this.lastName, this.pseudo);
    }
}
