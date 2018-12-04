package rest.util;

public class ResponseObject {
    private String resourceName;
    private int statusCode;
    private String message;

    public ResponseObject(String resourceName, int statusCode, String message) {
        this.resourceName = resourceName;
        this.statusCode = statusCode;
        this.message = message;
    }
}
