package cinema.controller;


import cinema.domain.dtos.PurchasedTicketDataDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cinema.domain.dtos.CinemaRoomDto;
import cinema.domain.dtos.SeatDto;
import cinema.service.CinemaRoomService;


@RestController
public class CinemaRoomController {

    private final CinemaRoomService cinemaRoomService;

    public CinemaRoomController(@Autowired CinemaRoomService cinemaRoomService) {
        this.cinemaRoomService = cinemaRoomService;
    }

    @GetMapping("/seats")
    public ResponseEntity<CinemaRoomDto> getCinemaRoom() {
        return ResponseEntity.ok(cinemaRoomService.getCinemaRoomDto());
    }

    @PostMapping(value = "/purchase")
    public ResponseEntity purchaseTicket(@Valid @RequestBody SeatDto seatDto) {
        return cinemaRoomService.purchaseTicket(seatDto);
    }

    @PostMapping(value = "/return")
    public ResponseEntity returnTicket(@RequestBody PurchasedTicketDataDto purchasedTicketDataDto) {
        return cinemaRoomService.returnTicket(purchasedTicketDataDto);
    }
}
