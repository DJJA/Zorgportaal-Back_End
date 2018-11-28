package rest.util;

public class Error {
    private String resourceName;
    private int errorCode;
    private String errorMessage;

    public Error(String resourceName, int errorCode, String errorMessage) {
        this.resourceName = resourceName;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
