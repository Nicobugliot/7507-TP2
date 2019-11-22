package Modelo.exceptions;

public class InsufficientPointsException extends RuntimeException {

    public InsufficientPointsException (String message){
        super(message);
    }
}
