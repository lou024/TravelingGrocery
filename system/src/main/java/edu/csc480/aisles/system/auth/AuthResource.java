package edu.csc480.aisles.system.auth;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import edu.csc480.aisles.system.user.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

// google auth imports
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Path("/check")
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    private static final String CLIENT_ID = "534704394140-vgqdcmbmel4gn1bfa7g3hd6h70qm5c6m.apps.googleusercontent.com";

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String authUser(String idTokenString) throws GeneralSecurityException, IOException {
        // dont know what this does
        HttpTransport transport = null;
        JsonFactory jsonFactory = null;

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                // Specify the CLIENT_ID of the app that accesses the backend:
                .setAudience(Collections.singletonList(CLIENT_ID)).build();


        GoogleIdToken idToken = verifier.verify(idTokenString);
        if (idToken != null) {
            Payload payload = idToken.getPayload();

            // Print user identifier
            String userId = payload.getSubject();
            System.out.println("User ID: " + userId);

            // Get profile information from payload
            String email = payload.getEmail();
            boolean emailVerified = payload.getEmailVerified();
            String name = (String) payload.get("name");
            String pictureUrl = (String) payload.get("picture");
            String locale = (String) payload.get("locale");
            String familyName = (String) payload.get("family_name");
            String givenName = (String) payload.get("given_name");

            // Use/store profile information
            return "name: " + name + " email: " + email;

        } else {
            return "Invalid ID token.";
        }

    }
}
