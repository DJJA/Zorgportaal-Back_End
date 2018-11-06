package rest.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("clients")
public class ClientsResource {

    @GET
    @Produces("application/json")
    public Response getAllClients() {
        return Response.status(200).entity("werkt!").build();
    }

    @GET
    @Path("/{clientId}")
    @Produces("application/json")
    public Response getClient(@PathParam("clientId") String clientIdAsString) {
        return Response.status(200).entity("werkt!").build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response addClient(String clientJson) {
        return Response.status(200).entity("werkt!").build();
    }

    @PUT
    @Path("/{clientId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response editClient(@PathParam("clientId") String clientIdAsString, String clientJson) {
        return Response.status(200).entity("werkt!").build();
    }
}
