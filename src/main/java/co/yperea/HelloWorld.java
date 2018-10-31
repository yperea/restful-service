package co.yperea;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/hello")
public class HelloWorld {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces({"text/plain","application/json", "application/json", MediaType.TEXT_HTML})
    @Path("/{first}/{last}")
    public Response getMessage(
            @PathParam("first") String firstName,
            @PathParam("last") String lastName
            ) {
        // Return a simple message
        String output = "{\"message\":\"Hello " + firstName + " " + lastName + "\"}";

        return Response.status(200)
                .entity(output)
                .build();



    }
}