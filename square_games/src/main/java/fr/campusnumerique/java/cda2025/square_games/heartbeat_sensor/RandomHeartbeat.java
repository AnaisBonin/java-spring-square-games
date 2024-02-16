package fr.campusnumerique.java.cda2025.square_games.heartbeat_sensor;

import org.springframework.stereotype.Service;

@Service
public class RandomHeartbeat implements HeartbeatSensor{
    @Override
    public int get() {
        return 0;
    }
}
