package edu.csc480.aisles.system.user;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@RequestScoped
@Path("/records")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> viewAllUsers() { return UserRecords.getUserRecords().viewAllUsers(); }

    // delete user
    // curl -X DELETE "http://localhost:8080/user/records" -H "accept: application/json" -H "Content-Type: application/json" -d "poop1"
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public User takeUser(String userID){ return UserRecords.getUserRecords().takeUser(userID); }

    // command to add user
    // curl -X POST "http://localhost:8080/user/records" -H "accept: */*" -H "Content-Type: application/json" -d "{\"id\":\"poopybutt\",\"sig\":\"indvos\",\"name\":\"James Poo\"}"
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void depositUser(User newUser){ UserRecords.getUserRecords().depositUser(newUser); }

    //curl -X PUT "http://localhost:8080/user/records" -H "accept: */*" -H "Content-Type: application/json" -d "{\"id\":\"123123\",\"sig\":\"wnhaicxindamcm\",\"name\":\"peter griffin\"}"
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(User newUser){
        UserRecords.getUserRecords().updateUser(newUser);
    }

}
