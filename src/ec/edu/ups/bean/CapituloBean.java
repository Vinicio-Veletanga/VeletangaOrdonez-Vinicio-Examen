package ec.edu.ups.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.AutorFacade;
import ec.edu.ups.ejb.CapituloFacade;
import ec.edu.ups.ejb.LibroFacade;
import ec.edu.ups.entidad.Autor;
import ec.edu.ups.entidad.Capitulo;
import ec.edu.ups.entidad.Libro;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class CapituloBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private CapituloFacade ejbCapituloFacade;

	@EJB
	private AutorFacade ejbAutorFacade;
	@EJB
	private LibroFacade ejbLibroFacade;

	private int numero;
	private int codigoa;
	private String titulo;
	private Capitulo capitulo;
	private Autor autor;
	private List<Capitulo> list;
	private List<Libro> libros;

	private List<Capitulo> capitulos;
	private String Nombre;
	private String ISBN;
	private int numPaginas;
	private Libro libro = new Libro();
	private Autor a;
	

	private String nombrea;
	private String Nacionalidad;
	
	public CapituloBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		capitulos = new ArrayList<Capitulo>(); 
		list = ejbCapituloFacade.findAll();
		libros = ejbLibroFacade.findAll();
		
		capitulo = new Capitulo();
		
	}
 

	public CapituloFacade getEjbCapituloFacade() {
		return ejbCapituloFacade;
	}

	public void setEjbCapituloFacade(CapituloFacade ejbCapituloFacade) {
		this.ejbCapituloFacade = ejbCapituloFacade;
	}

	public Capitulo[] getList() {
		return list.toArray(new Capitulo[0]);
	}
	
 
	public void setList(List<Capitulo> list) {
		this.list = list;
	}

	public Autor getA() {
		return a;
	}

	public void setA(Autor a) {
		this.a = a;
	}

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	
	public Libro addL() {
		libro.setNombre(this.Nombre);
		libro.setISBN(this.ISBN);
		libro.setNumPaginas(this.numPaginas);
		ejbLibroFacade.create(libro);
		libros = ejbLibroFacade.findAll();
		return libro;
	}
	
	public String add() {
		capitulo = new Capitulo();
		capitulo.setNumero(this.numero);
		capitulo.setTitulo(this.titulo);
		capitulo.setLibro(libro);
		autor = ejbAutorFacade.find(this.codigoa);
		capitulo.setAutor(autor);
		
		capitulos.add(capitulo);
		
		ejbCapituloFacade.create(capitulo);
		capitulo = new Capitulo();	
		list = ejbCapituloFacade.findAll();
		return null;
	}

	public String finID() {
		 a = ejbAutorFacade.find(this.codigoa);
		 System.out.println("valor de codigo es ;"+this.codigoa);
		 System.out.println("valor de autor"+a.getNombre()+a.getNacionalidad());
		 this.nombrea = a.getNombre();
		 this.Nacionalidad= a.getNacionalidad();
		 
		return null;
	}

	public String addLibro() {
		System.out.println("Entra al metodo");
		libro.setISBN(this.ISBN);
		libro.setNombre(this.Nombre);
		libro.setNumPaginas(this.numPaginas);
		libro.setCapitulos(capitulos);

		System.out.println("valor de libro"+libro.toString());
		
		ejbLibroFacade.create(libro);
		//capitulos = new ArrayList<Capitulo>();
		//libro = new Libro();
		libros = ejbLibroFacade.findAll();
		return null;
		
	}
	
	public AutorFacade getEjbAutorFacade() {
		return ejbAutorFacade;
	}
	

	public LibroFacade getEjbLibroFacade() {
		return ejbLibroFacade;
	}

	public void setEjbLibroFacade(LibroFacade ejbLibroFacade) {
		this.ejbLibroFacade = ejbLibroFacade;
	}

	public List<Capitulo> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}

	 

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getNombrea() {
		return nombrea;
	}

	public void setNombrea(String nombrea) {
		this.nombrea = nombrea;
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

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public int getCodigoa() {
		return codigoa;
	}

	public void setCodigoa(int codigoa) {
		this.codigoa = codigoa;
	}

	public void setEjbAutorFacade(AutorFacade ejbAutorFacade) {
		this.ejbAutorFacade = ejbAutorFacade;
	}

	public Capitulo getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String delete(Capitulo c) {
		ejbCapituloFacade.remove(c);
		list = ejbCapituloFacade.findAll();
		return null;
	}

	public String edit(Capitulo c) {
		c.setEditable(true);
		return null;
	}

	public String save(Capitulo c) {
		ejbCapituloFacade.edit(c);
		c.setEditable(false);
		return null;
	}

	public Libro[] getLibros() {
		return libros.toArray(new Libro[0]);
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	

}
