package edu.csc480.aisles.system.user;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.io.StringReader;

public class Consumer {

    public static User[] consumeWithJsonb(String targetUrl) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(targetUrl).request().get();
        User[] users = response.readEntity(User[].class);

        response.close();
        client.close();

        return users;
    }

}
