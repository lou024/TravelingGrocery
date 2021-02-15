package edu.csc480.helloworld.cj;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/testmessage")
public class CjServlet {

  @GET
   public String getRequest() {

     return "<b>Hello There</b>";
   }
}

