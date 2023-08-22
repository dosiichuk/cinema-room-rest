package cinema.domain.entities;

import java.util.UUID;

public class Seat {
    private UUID id;
    private int row;
    private int col;

    public Seat() {
    }

    public Seat(UUID id, int row, int col) {
        this.id = id;
        this.row = row;
        this.col = col;
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

    public void setId(UUID id) {
        this.id = id;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
