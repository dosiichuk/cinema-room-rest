package cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import cinema.domain.dtos.CinemaRoomDto;
import cinema.domain.dtos.SeatDto;
import cinema.domain.entities.CinemaRoom;
import cinema.mapper.CinemaRoomMapper;
import cinema.service.CinemaRoomService;


@RestController
public class CinemaRoomController {

    private final CinemaRoomService cinemaRoomService;
    private final CinemaRoomMapper cinemaRoomMapper;

    public CinemaRoomController(@Autowired CinemaRoomService cinemaRoomService,
                                @Autowired CinemaRoomMapper cinemaRoomMapper) {
        this.cinemaRoomService = cinemaRoomService;
        this.cinemaRoomMapper = cinemaRoomMapper;
    }

    @GetMapping("/seats")
    public ResponseEntity<CinemaRoomDto> getCinemaRoom() {
        CinemaRoom cinemaRoom = cinemaRoomService.getCinemaRoom();
        return ResponseEntity.ok(cinemaRoomMapper.mapToCinemaRoomDto(cinemaRoom));
    }

    @PostMapping("/purchase")
    public ResponseEntity<SeatDto> purchaseTicket() {

    }
}
