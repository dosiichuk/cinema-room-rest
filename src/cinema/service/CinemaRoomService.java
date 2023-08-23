package cinema.service;

import cinema.dictionary.ErrorMessage;
import cinema.domain.dtos.CinemaRoomDto;
import cinema.domain.dtos.SeatDto;
import cinema.domain.entities.CinemaRoom;
import cinema.domain.entities.Seat;
import cinema.exceptions.exceptions.TicketAlreadyPurchasedException;
import cinema.mapper.CinemaRoomMapper;
import cinema.mapper.SeatMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class CinemaRoomService {
    private final CinemaRoomMapper cinemaRoomMapper;
    private final SeatMapper seatMapper;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final CinemaRoom cinemaRoom = new CinemaRoom();

    public CinemaRoomService(@Autowired CinemaRoomMapper cinemaRoomMapper,
                             @Autowired SeatMapper seatMapper) {
        this.cinemaRoomMapper = cinemaRoomMapper;
        this.seatMapper = seatMapper;
    }

    public ResponseEntity<String> purchaseTicket(SeatDto seatDto) {
        ResponseEntity ticketPurchaseResponseEntity;
        Optional<Seat> seat = cinemaRoom
                .getSeats()
                .stream()
                .filter(s -> s.getRow() == seatDto.getRow() && s.getCol() == seatDto.getCol())
                .findFirst();
        if (seat.isEmpty()) {
            ticketPurchaseResponseEntity = new ResponseEntity(
                    Map.of("error", ErrorMessage.OUT_OF_BOUNDS.toString()),
                    HttpStatus.BAD_REQUEST);
        } else if (seat.get().isPurchased()) {
            throw new TicketAlreadyPurchasedException(ErrorMessage.TICKET_ALREADY_PURCHASED.toString());
        } else {
            try {
                ticketPurchaseResponseEntity = new ResponseEntity(
                        objectMapper.writeValueAsString(seatMapper.mapToSeatDto(seat.get())),
                        HttpStatus.OK);
                changeSeatAvailability(seat.get());
            } catch (JsonProcessingException e) {
                ticketPurchaseResponseEntity = new ResponseEntity(
                        Map.of("error", e.getMessage()),
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return ticketPurchaseResponseEntity;
    }

    public CinemaRoomDto getCinemaRoomDto() {
        return cinemaRoomMapper.mapToCinemaRoomDto(cinemaRoom);
    }

    public void changeSeatAvailability(Seat seat) {
        cinemaRoom.getSeats()
                .stream()
                .filter(s -> s.getRow() == seat.getRow()
                        && s.getCol() == seat.getCol())
                .findFirst().get()
                .setPurchased(true);
    }
}
