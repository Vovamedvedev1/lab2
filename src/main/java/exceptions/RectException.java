package exceptions;

public class RectException extends Exception{
    private final String message;

    public RectException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return "RectException. " + message;
    }
}
