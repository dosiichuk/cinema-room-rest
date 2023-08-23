package cinema.exceptions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidTicketTokenException extends RuntimeException {

    public InvalidTicketTokenException(String message) {
        super(message);
    }
}
