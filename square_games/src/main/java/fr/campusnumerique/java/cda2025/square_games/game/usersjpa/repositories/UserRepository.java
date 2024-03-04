package fr.campusnumerique.java.cda2025.square_games.game.usersjpa.repositories;

import fr.campusnumerique.java.cda2025.square_games.game.usersjpa.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}