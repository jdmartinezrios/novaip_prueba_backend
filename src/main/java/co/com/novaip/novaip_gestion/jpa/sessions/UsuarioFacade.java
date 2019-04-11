package co.com.novaip.novaip_gestion.jpa.sessions;

import co.com.novaip.novaip_gestion.jpa.entities.Usuario;
import co.com.novaip.novaip_gestion.jpa.entities.Usuario_;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Juan David Martinez Rios
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "co.com.novaip_novaip_gestion_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario findUsuarioByEmail(String email){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
        Root<Usuario> tercero = cq.from(Usuario.class);
        
        cq.where(cb.equal(tercero.get(Usuario_.email), email));
        TypedQuery<Usuario> tq = getEntityManager().createQuery(cq);
        
        try {
            return (Usuario) tq.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch(NoResultException e){
            return null;
        }
    }  
    
}
