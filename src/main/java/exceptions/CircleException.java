package exceptions;

public class CircleException extends Exception{
    private final String message;

    public CircleException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return "CircleException. " + message;
    }
}
