package fr.campusnumerique.java.cda2025.square_games.heartbeat_sensor;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomHeartbeat implements HeartbeatSensor{
    @Override
    public int get() {
        Random random = new Random();
        int min = 40;
        int max = 231;

        return random.nextInt(max-min) + min;
    }
}
