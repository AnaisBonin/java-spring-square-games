package fr.campusnumerique.java.cda2025.square_games;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SquareGamesApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(SquareGamesApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
