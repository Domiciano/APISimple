package config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("api")
public class ApplicationConfig extends Application {


    @Override
    public Set<Class<?>> getClasses() {
        //Registro de servicios
        Set<Class<?>> classSet = new HashSet<>();
        classSet.add(services.EstudiantesServices.class);
        return classSet;
    }
}
