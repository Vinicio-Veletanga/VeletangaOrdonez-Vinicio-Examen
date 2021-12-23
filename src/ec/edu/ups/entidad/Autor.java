package ec.edu.ups.entidad;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Autor
 *
 */
@Entity
@Named("autor")
public class Autor implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	
	private String nombre;
	private String Nacionalidad;
	@Transient
	private boolean editable;
	
	@OneToOne 
	@JoinColumn
	private Capitulo capitulo;
	public Autor() {

	}
	public Autor( String nombre, String nacionalidad) {
		super();
		this.nombre = nombre;
		Nacionalidad = nacionalidad;
	}
	
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	public Capitulo getCapitulo() {
		return capitulo;
	}
	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Nacionalidad == null) ? 0 : Nacionalidad.hashCode());
		result = prime * result + ((capitulo == null) ? 0 : capitulo.hashCode());
		result = prime * result + codigo;
		result = prime * result + (editable ? 1231 : 1237);
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (Nacionalidad == null) {
			if (other.Nacionalidad != null)
				return false;
		} else if (!Nacionalidad.equals(other.Nacionalidad))
			return false;
		if (capitulo == null) {
			if (other.capitulo != null)
				return false;
		} else if (!capitulo.equals(other.capitulo))
			return false;
		if (codigo != other.codigo)
			return false;
		if (editable != other.editable)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Autor [codigo=" + codigo + ", nombre=" + nombre + ", Nacionalidad=" + Nacionalidad + ", editable="
				+ editable + ", capitulo=" + capitulo + "]";
	}
  
	

	
   
}
