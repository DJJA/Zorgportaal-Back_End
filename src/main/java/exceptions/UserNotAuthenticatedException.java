package exceptions;

public class UserNotAuthenticatedException extends Exception {

    public UserNotAuthenticatedException() {
        super("User was not authenticated");
    }
}
