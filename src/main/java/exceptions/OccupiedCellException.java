package exceptions;

public class OccupiedCellException extends RuntimeException {

    public OccupiedCellException(String message){
        super(message);
    }
}
