package cinema.dictionary;

public enum ErrorMessage {
    OUT_OF_BOUNDS("The number of a row or a column is out of bounds!"),
    TICKET_ALREADY_PURCHASED("The ticket has been already purchased!"),
    INVALID_TICKET_TOKEN("Wrong token!");

    String error;

    ErrorMessage(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return this.error;
    }
}
