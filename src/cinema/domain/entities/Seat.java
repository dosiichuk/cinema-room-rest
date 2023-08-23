package cinema.domain.entities;

import java.util.Objects;
import java.util.UUID;

public class Seat {
    private UUID id;
    private UUID token;
    private int row;
    private int col;
    private int price;
    private boolean isPurchased;

    public Seat() {
    }

    public Seat(UUID id, int row, int col) {
        this.id = id;
        this.row = row;
        this.col = col;
        this.price = row <= 4 ? 10 : 8;
    }

    public Seat(int row, int col) {
        this.row = row;
        this.col = col;
        this.isPurchased = false;
        this.price = row <= 4 ? 10 : 8;
    }

    public UUID getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getPrice() {
        return price;
    }

    public UUID getToken() {
        return token;
    }

    public boolean isPurchased() {
        return isPurchased;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public void setPurchased(boolean purchased) {
        isPurchased = purchased;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return getRow() == seat.getRow() && getCol() == seat.getCol();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getCol());
    }

}
