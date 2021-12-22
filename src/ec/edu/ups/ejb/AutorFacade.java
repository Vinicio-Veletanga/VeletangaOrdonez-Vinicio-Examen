package ec.edu.ups.ejb;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Autor;


@Stateless
public class AutorFacade extends AbstractFacade<Autor> {

    @PersistenceContext(unitName = "VeletangaOrdonez-Vinicio-Examen")
    private EntityManager em;

    public AutorFacade() {
        super(Autor.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}

