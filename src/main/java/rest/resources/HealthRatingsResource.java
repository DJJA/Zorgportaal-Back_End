package rest.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("healthratings")
public class HealthRatingsResource {
    @GET
    @Produces("application/json")
    public Response getAllMentors() {
        return Response.status(200).entity("werkt!").build();
    }

    @GET
    @Path("/{mentorId}")
    @Produces("application/json")
    public Response getMentor(@PathParam("mentorId") String clientIdAsString) {
        return Response.status(200).entity("werkt!").build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response addMentor(String mentorJson) {
        return Response.status(200).entity("werkt!").build();
    }

    @PUT
    @Path("/{mentorId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response editMentor(@PathParam("mentorId") String mentorIdAsString, String mentorJson) {
        return Response.status(200).entity("werkt!").build();
    }

    @DELETE
    @Path("/{healthRatingId}")
    @Produces("application/json")
    public Response deleteHealthRating(@PathParam("healthRatingId") String healthRatingIdAsString) {
        return Response.status(200).entity("werkt!").build();
    }
}
