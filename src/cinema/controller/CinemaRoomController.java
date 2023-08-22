package cinema.controller;

import cinema.domain.entities.ErrorResponse;
import cinema.domain.entities.Seat;
import cinema.exceptions.TicketAlreadyPurchasedException;
import cinema.mapper.SeatMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.*;


import cinema.domain.dtos.CinemaRoomDto;
import cinema.domain.dtos.SeatDto;
import cinema.domain.entities.CinemaRoom;
import cinema.mapper.CinemaRoomMapper;
import cinema.service.CinemaRoomService;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class CinemaRoomController {

    private final CinemaRoomService cinemaRoomService;
    private final CinemaRoomMapper cinemaRoomMapper;
    private final SeatMapper seatMapper;
    private final ObjectMapper objectMapper;

    public CinemaRoomController(@Autowired CinemaRoomService cinemaRoomService,
                                @Autowired CinemaRoomMapper cinemaRoomMapper,
                                @Autowired SeatMapper seatMapper) {
        this.cinemaRoomService = cinemaRoomService;
        this.cinemaRoomMapper = cinemaRoomMapper;
        this.seatMapper = seatMapper;
        this.objectMapper = new ObjectMapper();
    }

    @GetMapping("/seats")
    public ResponseEntity<CinemaRoomDto> getCinemaRoom() {
        CinemaRoom cinemaRoom = cinemaRoomService.getCinemaRoom();
        return ResponseEntity.ok(cinemaRoomMapper.mapToCinemaRoomDto(cinemaRoom));
    }

    @PostMapping("/purchase")
    public ResponseEntity<Object> purchaseTicket(@RequestBody SeatDto seatDto) {
        Seat seat = seatMapper.mapToSeat(seatDto);
        try {
            Seat purchasedSeat = cinemaRoomService.purchaseTicket(seat);
            SeatDto purchasedSeatDto = seatMapper.mapToSeatDto(purchasedSeat);
            return ResponseEntity.ok(purchasedSeatDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
