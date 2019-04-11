package co.com.novaip.novaip_gestion.rest.services;

import co.com.novaip.novaip_gestion.jpa.entities.Tarea;
import co.com.novaip.novaip_gestion.jpa.sessions.TareaFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Juan David Martinez Rios
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("tareas")
public class TareaREST {

    @EJB
    private TareaFacade tareaEJB;

    /**
     *
     * @return todas las tareas
     */
    @GET
    public List<Tarea> findAll() {
        return tareaEJB.findAll();
    }

    /**
     * Metodo para crear las tareas en base de datos
     * @return estado http con mensaje
     */
    @POST
    public Response createUser(Tarea tarea) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            tareaEJB.create(tarea);
            return Response.status(Response.Status.CREATED)
                    .entity(gson.toJson("La tarea se registró correctamente"))
                    .build();

        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error al registrar la tarea!."))
                    .build();
        }
    }
}
