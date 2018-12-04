package rest.resources;

import com.google.gson.Gson;
import domain.Client;
import factory.ManagerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("clients")
public class ClientsResource {

    @GET
    @Produces("application/json")
    public Response getAllClients() {
        Iterable<Client> clients = ManagerFactory.getClientManager().getAllClients();   // TODO: Error handling

        return Response.status(200).entity(new Gson().toJson(clients)).build();
    }

    @GET
    @Path("/{clientId}")
    @Produces("application/json")
    public Response getClient(@PathParam("clientId") String clientIdAsString) {
        Long id = Long.parseLong(clientIdAsString);
        Client client = ManagerFactory.getClientManager().getClientById(id);

        return Response.status(200).entity(new Gson().toJson(client)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response addClient(String clientJson) {
        Client client = new Gson().fromJson(clientJson, Client.class);
        ManagerFactory.getClientManager().addClient(client);
        return Response.status(200).entity("{\"text\":\"goeie!\"}").build();
    }

    @PUT
    @Path("/{clientId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response editClient(@PathParam("clientId") String clientIdAsString, String clientJson) {
        // TODO: Client Id as String ???????
        Client client = new Gson().fromJson(clientJson, Client.class);
        ManagerFactory.getClientManager().updateClient(client);     // TODO: Misschien wel teruggeven, handig voor front-end?
        return Response.status(200).entity("werkt!").build();
    }
}
