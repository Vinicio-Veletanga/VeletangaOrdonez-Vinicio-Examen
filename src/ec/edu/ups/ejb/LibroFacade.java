package ec.edu.ups.ejb;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Libro;


@Stateless
public class LibroFacade extends AbstractFacade<Libro> {

    @PersistenceContext(unitName = "VeletangaOrdonez-Vinicio-Examen")
    private EntityManager em;

    public LibroFacade() {
        super(Libro.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}

