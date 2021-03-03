package edu.csc480.travelingGrocery.system.bobby;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/bobby")
public class bobbyApplication extends Application{
    public Set<Class<?>> getClasses(){
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(AlbumResource.class);
        return classes;
    }
}
