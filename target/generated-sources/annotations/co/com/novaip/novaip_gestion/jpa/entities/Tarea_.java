package co.com.novaip.novaip_gestion.jpa.entities;

import co.com.novaip.novaip_gestion.jpa.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-11T04:05:55")
@StaticMetamodel(Tarea.class)
public class Tarea_ { 

    public static volatile SingularAttribute<Tarea, String> descripcion;
    public static volatile SingularAttribute<Tarea, Integer> tareaId;
    public static volatile SingularAttribute<Tarea, Boolean> estado;
    public static volatile SingularAttribute<Tarea, Date> fechaEjecucion;
    public static volatile SingularAttribute<Tarea, Usuario> usuarioId;

}