package rest.resources;

import com.google.gson.Gson;
import domain.Client;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("mentors/{mentorId}/clients")
public class MentorsClientsResource {
    @PathParam("mentorId") private String mentorIdAsString;
    private Long mentorId;

    public MentorsClientsResource(Long mentorId) {
        this.mentorId = Long.parseLong(mentorIdAsString);
    }

    @GET
    @Produces("application/json")
    public Response getClients() {
        return Response.status(200).entity("{\"text\":\"goeie!\"}").build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response addClientToMentor(String clientJson) {
        Client client = new Gson().fromJson(clientJson, Client.class);

        return Response.status(200).entity("{\"text\":\"goeie!\"}").build();
    }

    @DELETE
    @Path("/{clientId}")
    @Produces("application/json")
    public Response removeClientFromMentor(@PathParam("clientId") String clientIdAsString) {
        Long clientId = Long.parseLong(clientIdAsString);

        return Response.status(200).entity("{\"text\":\"goeie!\"}").build();
    }
}
