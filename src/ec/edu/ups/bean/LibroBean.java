package ec.edu.ups.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.AutorFacade;
import ec.edu.ups.ejb.CapituloFacade;
import ec.edu.ups.ejb.LibroFacade;
import ec.edu.ups.entidad.Capitulo;
import ec.edu.ups.entidad.Libro; 

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class LibroBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private LibroFacade ejbLibroFacade;
	
	
	private String Nombre;
	private String ISBN;
	private int numPaginas;

	private List<Libro> list;

	public LibroBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		list = ejbLibroFacade.findAll();
		
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public LibroFacade getEjbLibroFacade() {
		return ejbLibroFacade;
	}

	public void setEjbLibroFacade(LibroFacade ejbLibroFacade) {
		this.ejbLibroFacade = ejbLibroFacade;
	}

	public Libro[] getList() {
		return list.toArray(new Libro[0]);
	}

	public void setList(List<Libro> list) {
		this.list = list;
	}

	public String add() {
		ejbLibroFacade.create(new Libro(this.Nombre, this.ISBN,this.numPaginas));
		list = ejbLibroFacade.findAll();
		return null;
	}

	public String delete(Libro c) {
		ejbLibroFacade.remove(c);
		list = ejbLibroFacade.findAll();
		return null;
	}

	public String edit(Libro c) {
		c.setEditable(true);
		return null;
	}

	public String save(Libro c) {
		ejbLibroFacade.edit(c);
		c.setEditable(false);
		return null;
	}
	
	
	

}
