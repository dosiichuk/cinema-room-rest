package cinema.domain.dtos;

public class SeatDto {
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

    public int getCol() {
        return col;
    }

    public int getPrice() {
        return price;
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
