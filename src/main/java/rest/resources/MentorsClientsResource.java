package rest.resources;

import com.google.gson.Gson;
import domain.Client;
import factory.ManagerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("mentors/{mentorId}/clients")
public class MentorsClientsResource {
    @PathParam("mentorId") private String mentorIdAsString;

    private Long getMentorId() {
        return Long.parseLong(mentorIdAsString);
    }

    @GET
    @Produces("application/json")
    public Response getClients() {
        Iterable<Client> clients = ManagerFactory.getClientManager().getClientsByMentorId(this.getMentorId());
        return Response.status(200).entity(new Gson().toJson(clients)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response addClientToMentor(String clientJson) {
        Client client = new Gson().fromJson(clientJson, Client.class);
        ManagerFactory.getMentorManager().addClientToMentor(this.getMentorId(), client.getId());

        return Response.status(200).entity("{\"text\":\"goeie!\"}").build();
    }

    @DELETE
    @Path("/{clientId}")
    @Produces("application/json")
    public Response removeClientFromMentor(@PathParam("clientId") String clientIdAsString) {
        Long clientId = Long.parseLong(clientIdAsString);
        ManagerFactory.getMentorManager().removeClientFromMentor(this.getMentorId(), clientId);

        return Response.status(200).entity("{\"text\":\"goeie!\"}").build();
    }
}
