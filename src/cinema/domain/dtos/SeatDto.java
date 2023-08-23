package cinema.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class SeatDto {
    @Min(1)
    @Max(9)
    private int row;
    private int col;
    private int price;
    private boolean isPurchased;

    public SeatDto() {
    }

    public SeatDto(int row, int column) {
        this.row = row;
        this.col = column;
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
}
