package exceptions;

public class NotExistentInputException extends Exception{
    public NotExistentInputException() {
        super("The input inserted don't exist in the machine");
    }
}
