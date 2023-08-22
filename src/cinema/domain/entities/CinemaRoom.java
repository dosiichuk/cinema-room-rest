package cinema.domain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CinemaRoom {
    private final int NUM_ROWS = 9;
    private final int NUM_COLS = 9;
    private final int CAPACITY = NUM_ROWS * NUM_COLS;
    private List<Seat> seats;

    public CinemaRoom() {
        seats = new ArrayList<>();
        initSeats();
    }

    public CinemaRoom(List<Seat> seats) {
        this.seats = seats;
    }

    private void initSeats() {
        for (int i = 1; i <= NUM_ROWS; i++) {
            for (int j = 1; j <= NUM_COLS; j++) {
                seats.add(new Seat(UUID.randomUUID(), i, j));
            }
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public int getNUM_ROWS() {
        return NUM_ROWS;
    }

    public int getNUM_COLS() {
        return NUM_COLS;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
