package services;

import model.Estudiante;
import provider.EstudianteProvider;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("estudiante")
public class EstudiantesServices {


    @Path("all")
    @GET
    public Response getAll() {
        try {
            EstudianteProvider provider = new EstudianteProvider();
            ArrayList<Estudiante> estudiantes = provider.getAll();
            return Response
                    .status(200)
                    .entity(estudiantes)
                    .header("Access-Control-Allow-Origin","*")
                    .build();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return Response
                    .status(500)
                    .entity("ERROR")
                    .build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return Response
                    .status(500)
                    .entity("No hay driver drvier")
                    .build();
        }
    }

    @Path("create")
    @POST
    public Response create() {
        //...
        return null;
    }


}
