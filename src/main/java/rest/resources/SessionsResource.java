package rest.resources;

import authentication.util.UserCredentials;
import com.google.gson.Gson;
import exceptions.TokenGenerationException;
import exceptions.UserNotAuthenticatedException;
import factory.ManagerFactory;
import rest.util.Error;
import rest.util.Token;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("sessions")
public class SessionsResource {

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response authenticateUser(String userCredentialsJson) {
        Gson gson = new Gson();
        UserCredentials userCredentials = gson.fromJson(userCredentialsJson, UserCredentials.class);
        Token token;
        try {
            String jwt = ManagerFactory.getSessionManager().authenticateUser(userCredentials);
            token = new Token(jwt);
        } catch (UserNotAuthenticatedException e) {
            Error error = new Error("sessions", 401, "Invalid user credentials.");
            return Response.status(401).entity(gson.toJson(error)).build();
        } catch (TokenGenerationException e) {
            Error error = new Error("sessions", 500, "Something went wrong when authenticating the user.");
            return Response.status(500).entity(gson.toJson(error)).build();
        }
        return Response.status(200).entity(gson.toJson(token)).build();
    }
}
