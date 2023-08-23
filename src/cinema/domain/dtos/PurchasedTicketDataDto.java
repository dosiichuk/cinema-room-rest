package cinema.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class PurchasedTicketDataDto {
    private UUID token;
    private SeatDto seat;

    public PurchasedTicketDataDto(SeatDto seat) {
        this.seat = seat;
        this.token = seat.getToken();
    }

    public PurchasedTicketDataDto() {
    }

    public UUID getToken() {
        return token;
    }
    @JsonProperty("ticket")
    public SeatDto getTicket() {
        return seat;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public void setSeat(SeatDto seat) {
        this.seat = seat;
    }
}
