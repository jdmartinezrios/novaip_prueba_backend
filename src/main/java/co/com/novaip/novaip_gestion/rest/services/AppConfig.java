package co.com.novaip.novaip_gestion.rest.services;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Juan David Martinez Rios
 */
@ApplicationPath("api")
public class AppConfig extends ResourceConfig {
  
    public AppConfig(){
         packages("co.com.iemergencia.rest.services");
    }
}
