package cinema.mapper;


import cinema.domain.dtos.SeatDto;
import cinema.domain.entities.Seat;
import org.springframework.stereotype.Component;

@Component
public class SeatMapper {

    public SeatDto mapToSeatDto(Seat seat) {
        return new SeatDto(seat.getRow(), seat.getCol());
    }

    public Seat mapToSeat(SeatDto seatDto) {
        return new Seat(seatDto.getRow(), seatDto.getCol());
    }

}
