package Modelo.exceptions;

public class OccupiedCellException extends RuntimeException {

    public OccupiedCellException(String message){
        super(message);
    }
}
