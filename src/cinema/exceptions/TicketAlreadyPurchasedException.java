package cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class TicketAlreadyPurchasedException extends RuntimeException {

    private String error;

    public TicketAlreadyPurchasedException(String message) {
        super(message);
        this.error = message;
    }
}
