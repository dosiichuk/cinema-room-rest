package cinema.service;

import cinema.domain.entities.CinemaRoom;
import org.springframework.stereotype.Service;

@Service
public class CinemaRoomService {

    public CinemaRoom getCinemaRoom() {
        return new CinemaRoom();
    }
}
