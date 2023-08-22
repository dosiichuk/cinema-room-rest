package cinema.domain.dtos;

import cinema.domain.entities.Seat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CinemaRoomDto {
    private final int NUM_ROWS = 9;
    private final int NUM_COLS = 9;
    private final int CAPACITY = NUM_ROWS * NUM_COLS;
    private List<SeatDto> seats;

    public CinemaRoomDto(List<SeatDto> seats) {
        this.seats = seats;
    }

    @JsonProperty("available_seats")
    public List<SeatDto> getSeats() {
        return seats;
    }

    @JsonProperty("total_rows")
    public int getNUM_ROWS() {
        return NUM_ROWS;
    }

    @JsonProperty("total_columns")
    public int getNUM_COLS() {
        return NUM_COLS;
    }

    public void setSeats(List<SeatDto> seats) {
        this.seats = seats;
    }
}