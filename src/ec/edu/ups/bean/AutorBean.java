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
import ec.edu.ups.entidad.Autor;
import ec.edu.ups.entidad.Capitulo;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class AutorBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private AutorFacade ejbAutorFacade;
	private int codigo;
	private String nombre;
	private String Nacionalidad;
	private Autor a;
	private Capitulo cap;
	private List<Autor> list;
	private List<String> nacionalidades;
	
	
	private String level1;
	private boolean levelDisabled; 
	

	public AutorBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() { 
		list = ejbAutorFacade.findAll();
		nacionalidades = new ArrayList<String>();
		nacionalidades.add("Ecuatoriano");

		nacionalidades.add("Combiano");

		nacionalidades.add("Peruano");
	}
 

	
	public String getLevel1() {
		return level1;
	}

	public void setLevel1(String level1) {
		this.level1 = level1;
	}

	public boolean isLevelDisabled() {
		return levelDisabled;
	}

	public void setLevelDisabled(boolean levelDisabled) {
		this.levelDisabled = levelDisabled;
	}

	public AutorFacade getEjbAutorFacade() {
		return ejbAutorFacade;
	}
	

	public Autor getA() {
		return a;
	}

	public void setA(Autor a) {
		this.a = a;
	}

	public Capitulo getCap() {
		return cap;
	}

	public void setCap(Capitulo cap) {
		this.cap = cap;
	}
	

	public String[] getNacionalidades() {
		return  nacionalidades.toArray(new String[0]);
	}

	public void setNacionalidades(List<String> nacionalidades) {
		this.nacionalidades = nacionalidades;
	}

	public void setEjbAutorFacade(AutorFacade ejbAutorFacade) {
		this.ejbAutorFacade = ejbAutorFacade;
	}

	public Autor[] getList() {
		return list.toArray(new Autor[0]);
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public void setList(List<Autor> list) {
		this.list = list;
	}

	public String add() {
		ejbAutorFacade.create(new Autor(this.nombre,this.Nacionalidad));
		list = ejbAutorFacade.findAll();
		return null;
	}

	public String delete(Autor c) {
		ejbAutorFacade.remove(c);
		list = ejbAutorFacade.findAll();
		return null;
	}

	public String edit(Autor c) {
		c.setEditable(true);
		return null;
	}

	public String save(Autor c) {
		ejbAutorFacade.edit(c);
		c.setEditable(false);
		return null;
	}
	
	public String finID() {
		 a = ejbAutorFacade.find(this.codigo);
		 System.out.println("valor de codigo es ;"+this.codigo);
		 System.out.println("valor de autor"+a.getNombre()+a.getNacionalidad());
		 this.nombre = a.getNombre();
		 this.Nacionalidad= a.getNacionalidad();
		 
		return null;
	}

	public String addC(Autor c) {
		c = ejbAutorFacade.find(this.codigo);
		ejbAutorFacade.edit(c);
		c.setEditable(false);
		return null;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	

}
