package edu.csc480.travelingGrocery.system;

import org.eclipse.microprofile.jwt.Claim;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/properties")
public class SystemResource {

    @Inject
    @Claim("groups")
    private JsonArray roles;

    @GET
    @Path("/username")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin", "user"})
    public String getUsername() { return System.getProperties().getProperty("user.name"); }

    @GET
    @Path("/os")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin"})
    public String getOS() { return System.getProperties().getProperty("os.name"); }

    @GET
    @Path("/jwtroles")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin", "user"})
    public String getJwtRoles() { return roles.toString(); }

}
