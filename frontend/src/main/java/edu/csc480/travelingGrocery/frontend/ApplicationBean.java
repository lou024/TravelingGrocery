package edu.csc480.travelingGrocery.frontend;

import edu.csc480.travelingGrocery.frontend.client.SystemClient;
import edu.csc480.travelingGrocery.frontend.util.SessionUtils;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named
public class ApplicationBean {

    @Inject
    @RestClient
    private SystemClient defaultRestClient;

    public String getJwt() {
        String jwtTokenString = SessionUtils.getJwtToken();
        String authHeader = "Bearer " + jwtTokenString;
        return authHeader;
    }

    public String getOs() {
        String authHeader = getJwt();
        String os;
        try {
            os = defaultRestClient.getOs(authHeader);
        } catch (Exception e) {
            return "You are not authorized to access this system property";
        }

        return os;
    }

    public String getUsername() {
        String authHeader = getJwt();
        return defaultRestClient.getUsername(authHeader);
    }

    public String getJwtRoles() {
        String authHeader = getJwt();
        return defaultRestClient.getJwtRoles(authHeader);
    }
}
