package exceptions;

public class FootingCylinderException extends Exception{
    private final String message;

    public FootingCylinderException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return "FootingCylinderException. " + message;
    }
}
