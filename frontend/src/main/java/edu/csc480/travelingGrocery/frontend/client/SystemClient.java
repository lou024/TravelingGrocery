package edu.csc480.travelingGrocery.frontend.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "https://localhost:8443/system")
@Path("/properties")
@RequestScoped
public interface SystemClient extends AutoCloseable {

    @GET
    @Path("/username")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsername(@HeaderParam("Authorization") String authHeader);

    @GET
    @Path("/os")
    @Produces(MediaType.APPLICATION_JSON)
    public String getOs(@HeaderParam("Authorization") String authHeader);

    @GET
    @Path("/jwtroles")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJwtRoles(@HeaderParam("Authorization") String authHeader);


}
