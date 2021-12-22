package ec.edu.ups.ejb;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Capitulo;


@Stateless
public class CapituloFacade extends AbstractFacade<Capitulo> {

    @PersistenceContext(unitName = "VeletangaOrdonez-Vinicio-Examen")
    private EntityManager em;

    public CapituloFacade() {
        super(Capitulo.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}

