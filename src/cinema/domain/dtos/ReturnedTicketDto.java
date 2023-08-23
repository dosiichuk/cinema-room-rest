package cinema.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReturnedTicketDto {

    private SeatDto seatDto;

    public ReturnedTicketDto(SeatDto seatDto) {
        this.seatDto = seatDto;
    }

    public ReturnedTicketDto() {
    }

    @JsonProperty("returned_ticket")
    public SeatDto getSeatDto() {
        return seatDto;
    }

    public void setSeatDto(SeatDto seatDto) {
        this.seatDto = seatDto;
    }
}
