package cinema.mapper;

import cinema.domain.dtos.CinemaRoomDto;
import cinema.domain.entities.CinemaRoom;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CinemaRoomMapper {

    private final SeatMapper seatMapper;

    public CinemaRoomMapper(SeatMapper seatMapper) {
        this.seatMapper = seatMapper;
    }

    public CinemaRoomDto mapToCinemaRoomDto(CinemaRoom cinemaRoom) {
        return new CinemaRoomDto(cinemaRoom
                .getSeats()
                .stream()
                .map(seat -> seatMapper.mapToSeatDto(seat))
                .collect(Collectors.toList()));
    }

    public CinemaRoom mapToCinemaRoom(CinemaRoomDto cinemaRoomDto) {
        return new CinemaRoom(cinemaRoomDto.getSeats()
                .stream()
                .map(seatDto -> seatMapper.mapToSeat(seatDto))
                .collect(Collectors.toList()));
    }
}
