package exceptions;

public class HeightCylinderException extends Exception{
    private final String message;

    public HeightCylinderException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return "HeightCylinderException. " + message;
    }
}
