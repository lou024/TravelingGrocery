package edu.csc480.aisles.system.user;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

public class User {
    public String id, name, sig;

    // Object property that does not map to a JSON
    @JsonbTransient
    public boolean auth;

    public User() {

    }

    @JsonbCreator
    public User(@JsonbProperty("id") String id,
                @JsonbProperty("sig") String sig,
                @JsonbProperty("name") String name) {

        this.name = name;
        this.id = id;
        this.sig = sig;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getSig() { return sig; }

    @Override
    public String toString() {
        return "id:" + id + " sig: " + sig;
    }
}
