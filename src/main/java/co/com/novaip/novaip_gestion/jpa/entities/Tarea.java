package co.com.novaip.novaip_gestion.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan David Martinez Rios
 */
@Entity
@Table(name = "tarea", schema = "novaip_gestion")
@XmlRootElement
public class Tarea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tarea_id")
    private Integer tareaId;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_ejecucion")
    @Temporal(TemporalType.DATE)
    private Date fechaEjecucion;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne
    private Usuario usuarioId;

    public Tarea() {
    }

    public Tarea(Integer tareaId) {
        this.tareaId = tareaId;
    }

    public Tarea(Integer tareaId, String descripcion, Date fechaEjecucion, Boolean estado, Usuario usuarioId) {
        this.tareaId = tareaId;
        this.descripcion = descripcion;
        this.fechaEjecucion = fechaEjecucion;
        this.estado = estado;
        this.usuarioId = usuarioId;
    }

    public Integer getTareaId() {
        return tareaId;
    }

    public void setTareaId(Integer tareaId) {
        this.tareaId = tareaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(Date fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "co.com.novaip.novaip_gestion.jpa.entities.Tarea[ tareaId=" + tareaId + " ]";
    }
    
}
