package co.com.novaip.novaip_gestion.rest.services;

import co.com.novaip.novaip_gestion.jpa.entities.Usuario;
import co.com.novaip.novaip_gestion.jpa.sessions.UsuarioFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Juan David Martinez Rios
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("usuarios")
public class UsuarioREST {

    @EJB
    private UsuarioFacade userEJB;

    /**
     * 
     * @return Todos los usuarios que estan en BD
     */
    @GET
    public List<Usuario> findAll() {
        return userEJB.findAll();
    }
    
    /**
     * Metodo REST que permite crear usuarios en BD
     * @param usuario Objeto que recibe como parametro
     * @return un estado http con mensaje
     */
    @POST
    public Response createUser(Usuario usuario) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            /**
             * Condicion para validar si el usuario ya esta registrado
             */
            if (userEJB.findUsuarioByEmail(usuario.getEmail()) == null) {
                userEJB.create(usuario);
                return Response.status(Response.Status.CREATED)
                        .entity(gson.toJson("El usuario se registró correctamente"))
                        .build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(gson.toJson("El usuario ya se encuentra registrado!."))
                        .build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error al registrar el usuario!."))
                    .build();
        }
    }
}
