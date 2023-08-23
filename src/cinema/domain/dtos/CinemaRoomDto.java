package cinema.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

public class CinemaRoomDto {
    private final int NUM_ROWS = 9;
    private final int NUM_COLS = 9;
    private List<SeatDto> seats;

    public CinemaRoomDto(List<SeatDto> seats) {
        this.seats = seats;
    }

    @JsonIgnore
    public List<SeatDto> getSeats() {
        return seats;
    }

    @JsonProperty("available_seats")
    public List<SeatDto> getAvailableSeats() {
        return seats.stream()
                .filter(seatDto -> !seatDto.isPurchased())
                .collect(Collectors.toList());
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
