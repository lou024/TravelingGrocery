package edu.csc480.aisles.system.mork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class MorkServlet {

	@GET
  public String doAThing() {
	    return "Look MA, IM DOIN A THING!";
	}
}
