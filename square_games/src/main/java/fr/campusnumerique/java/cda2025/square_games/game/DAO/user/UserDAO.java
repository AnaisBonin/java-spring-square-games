package fr.campusnumerique.java.cda2025.square_games.game.DAO.user;

import fr.campusnumerique.java.cda2025.square_games.game.controller.DO.User;
import fr.campusnumerique.java.cda2025.square_games.game.controller.DTO.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserDAO {
    public List<UserDTO> getAllUsers();
    public UserDTO getUserById(UUID id);
    public UserDTO addUser(UserDTO userDTO);
    public UserDTO updateUser(UUID id);
    public void deleteUser(UUID id);
}

