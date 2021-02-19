package edu.csc480.helloworld.mork;

import java.util.Set;
import java.util.UUID;

import java.io.StringWriter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.JsonArrayBuilder;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import javax.validation.Validator;
import javax.validation.ConstraintViolation;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Path("/")
@ApplicationScoped
public class MorkServlet {
	@Inject
	MongoDatabase db;

	@Inject
	Validator validator;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String add(ShinyThing shinyThing) {

		Set<ConstraintViolation<ShinyThing>> violations = validator.validate(shinyThing);
		if(violations.size() > 0) {
			JsonArrayBuilder messages = Json.createArrayBuilder();
			for (ConstraintViolation<ShinyThing> v : violations) {
				messages.add(v.getMessage());
			}
			return messages.build().toString();
		}

		MongoCollection<Document> stuff = db.getCollection("StuffnThings");
		Document newThing = new Document();
		newThing.put("Name",shinyThing.getName());
		newThing.put("Description",shinyThing.getDescription());
		newThing.put("idNode",UUID.randomUUID().toString());
		stuff.insertOne(newThing);
		return newThing.toJson();
	}

	@DELETE
	@Path("/{id}")
	public String remove(@PathParam("id") String id) {
		MongoCollection<Document> stuff = db.getCollection("StuffnThings");
		stuff.deleteOne(new Document("idNode", id));
		return "";
	}

	@GET
	public String retrieve() {
		StringWriter sb = new StringWriter();

		try {
			MongoCollection<Document> stuff = db.getCollection("StuffnThings");
			sb.append("[");
			boolean first = true;
			for (Document d : stuff.find()) {
				if (!first) sb.append(",");
				else first = false;
				sb.append(d.toJson());
			}
			sb.append("]");
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return sb.toString();
	}
}
