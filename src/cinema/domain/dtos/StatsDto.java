package cinema.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatsDto {
    private int currentIncome;
    private int numAvailableSeats;
    private int numPurchasedTickets;

    public StatsDto(int currentIncome, int numAvailableSeats, int numPurchasedTickets) {
        this.currentIncome = currentIncome;
        this.numAvailableSeats = numAvailableSeats;
        this.numPurchasedTickets = numPurchasedTickets;
    }

    @JsonProperty("current_income")
    public int getCurrentIncome() {
        return currentIncome;
    }

    @JsonProperty("number_of_available_seats")
    public int getNumAvailableSeats() {
        return numAvailableSeats;
    }

    @JsonProperty("number_of_purchased_tickets")
    public int getNumPurchasedTickets() {
        return numPurchasedTickets;
    }

    public void setCurrentIncome(int currentIncome) {
        this.currentIncome = currentIncome;
    }

    public void setNumAvailableSeats(int numAvailableSeats) {
        this.numAvailableSeats = numAvailableSeats;
    }

    public void setNumPurchasedTickets(int numPurchasedTickets) {
        this.numPurchasedTickets = numPurchasedTickets;
    }
}
