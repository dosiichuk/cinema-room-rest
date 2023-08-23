package cinema.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class SeatDto {
    private int row;
    private int col;
    private int price;
    private UUID token;
    private boolean isPurchased;

    public SeatDto() {
    }

    public SeatDto(int row, int column, UUID token) {
        this.row = row;
        this.col = column;
        this.token = token;
        this.price = row <= 4 ? 10 : 8;
    }

    public int getRow() {
        return row;
    }

    @JsonProperty("column")
    public int getCol() {
        return col;
    }

    public int getPrice() {
        return price;
    }

    @JsonIgnore
    public UUID getToken() {
        return token;
    }

    @JsonIgnore
    public boolean isPurchased() {
        return isPurchased;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}
