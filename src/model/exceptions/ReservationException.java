package model.exceptions;

import java.io.Serial;

public class ReservationException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public ReservationException(String msg) {
        super(msg);
    }
}
