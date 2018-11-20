package rest.resources;

import com.google.gson.Gson;
import domain.Mentor;
import factory.ManagerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("mentors")
public class MentorsResource {

    @GET
    @Produces("application/json")
    public Response getAllMentors() {
        Iterable<Mentor> mentors = ManagerFactory.getMentorManager().getAllMentors();

        return Response.status(200).entity(new Gson().toJson(mentors)).build();
    }

    @GET
    @Path("/{mentorId}")
    @Produces("application/json")
    public Response getMentor(@PathParam("mentorId") String clientIdAsString) {
        Long id = Long.parseLong(clientIdAsString);
        Mentor mentor = ManagerFactory.getMentorManager().getMentorById(id);
        return Response.status(200).entity(new Gson().toJson(mentor)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response addMentor(String mentorJson) {
        Mentor mentor = new Gson().fromJson(mentorJson, Mentor.class);
        ManagerFactory.getMentorManager().addMentor(mentor);
        return Response.status(200).entity("werkt!").build();
    }

    @PUT
    @Path("/{mentorId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response editMentor(@PathParam("mentorId") String mentorIdAsString, String mentorJson) {
        Mentor mentor = new Gson().fromJson(mentorJson, Mentor.class);
        ManagerFactory.getMentorManager().updateMentor(mentor);
        return Response.status(200).entity("werkt!").build();
    }
}
