package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Libro
 *
 */
@Entity

public class Libro implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	
	private String Nombre;
	private String ISBN;
	private int numPaginas;
	
	@Transient
	private boolean editable;
	
	//RELACION ONE MUCHOS personas-doctores
	@OneToMany(mappedBy ="capitulo")
	private List<Capitulo> capitulos;

	public Libro() { 
		// TODO Auto-generated constructor stub
	}


	public Libro( String nombre, String iSBN, int numPaginas) {
		super();
		this.Nombre = nombre;
		this.ISBN = iSBN;
		this.numPaginas = numPaginas;
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


	public List<Capitulo> getCapitulos() {
		return capitulos;
	}


	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}


	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", Nombre=" + Nombre + ", ISBN=" + ISBN + ", numPaginas=" + numPaginas
				+ ", editable=" + editable + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + codigo;
		result = prime * result + (editable ? 1231 : 1237);
		result = prime * result + numPaginas;
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
		Libro other = (Libro) obj;
		if (ISBN == null) {
			if (other.ISBN != null)
				return false;
		} else if (!ISBN.equals(other.ISBN))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (codigo != other.codigo)
			return false;
		if (editable != other.editable)
			return false;
		if (numPaginas != other.numPaginas)
			return false;
		return true;
	}
 
}
