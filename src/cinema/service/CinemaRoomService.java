package cinema.service;

import cinema.dictionary.ErrorMessage;
import cinema.domain.dtos.CinemaRoomDto;
import cinema.domain.dtos.PurchasedTicketDataDto;
import cinema.domain.dtos.ReturnedTicketDto;
import cinema.domain.dtos.SeatDto;
import cinema.domain.entities.CinemaRoom;
import cinema.domain.entities.Seat;
import cinema.exceptions.exceptions.InvalidTicketTokenException;
import cinema.exceptions.exceptions.TicketAlreadyPurchasedException;
import cinema.mapper.CinemaRoomMapper;
import cinema.mapper.SeatMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

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
            changeSeatAvailability(seat.get());
            ticketPurchaseResponseEntity = new ResponseEntity(
                    new PurchasedTicketDataDto(seatMapper.mapToSeatDto(seat.get())),
                    HttpStatus.OK);
        }
        return ticketPurchaseResponseEntity;
    }

    public CinemaRoomDto getCinemaRoomDto() {
        return cinemaRoomMapper.mapToCinemaRoomDto(cinemaRoom);
    }

    public void changeSeatAvailability(Seat seat) {
        Seat seat1 = cinemaRoom.getSeats()
                .stream()
                .filter(s -> s.getRow() == seat.getRow()
                        && s.getCol() == seat.getCol())
                .findFirst().get();
        seat1.setPurchased(true);
        seat1.setToken(UUID.randomUUID());
    }

    public ResponseEntity returnTicket(PurchasedTicketDataDto purchasedTicketDataDto) {
        Optional<Seat> seatOptional = cinemaRoom.getSeats()
                .stream()
                .filter(s -> s.getToken() != null && s.getToken().equals(purchasedTicketDataDto.getToken()))
                .findFirst();
        if (seatOptional.isEmpty()) {
            throw new InvalidTicketTokenException(ErrorMessage.INVALID_TICKET_TOKEN.toString());
        } else {
            Seat seat = seatOptional.get();
            seat.setToken(null);
            seat.setPurchased(false);
            return new ResponseEntity(new ReturnedTicketDto(seatMapper.mapToSeatDto(seat)), HttpStatus.OK);

        }
    }
}
