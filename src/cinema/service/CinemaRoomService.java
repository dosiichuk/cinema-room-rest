package cinema.service;

import cinema.domain.entities.CinemaRoom;
import cinema.domain.entities.Seat;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Service
public class CinemaRoomService {
    private final CinemaRoom cinemaRoom = new CinemaRoom();

    public Seat purchaseTicket(Seat seat) {
        if (seat.getRow() < 1 || seat.getRow() > 9 ||
        seat.getCol() < 1 || seat.getCol() > 9) {
            throw new RuntimeException("The number of a row or a column is out of bounds!");
        }
        Seat foundSeat = cinemaRoom
                .getSeats()
                .stream()
                .filter(roomSeat -> Objects.equals(seat, roomSeat))
                .collect(Collectors.toList())
                .get(0);
        System.out.println("found" + foundSeat.getRow() + foundSeat.getCol());
        if (foundSeat.isPurchased()) {
            throw new RuntimeException("The ticket has been already purchased!");
        } else {
            foundSeat.setPurchased(true);
            return foundSeat;
        }
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }
}
