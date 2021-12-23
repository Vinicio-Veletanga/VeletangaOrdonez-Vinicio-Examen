package ec.edu.ups.entidad;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Capitulo
 *
 */
@Entity
@Named("capitulo")
public class Capitulo implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	private int numero;
	private String titulo;
	@ManyToOne
	private Libro libro;
	
	
	@OneToOne
	@JoinColumn
	private Autor autor;
	
	@Transient
	private boolean editable;
	
	public Capitulo() {
	}

	public Capitulo(int numero, String titulo) {
		super();
		this.numero = numero;
		this.titulo = titulo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

 

	public Autor getAutor() {
		return autor;
	}
	

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + codigo;
		result = prime * result + (editable ? 1231 : 1237);
		result = prime * result + ((libro == null) ? 0 : libro.hashCode());
		result = prime * result + numero;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Capitulo other = (Capitulo) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (codigo != other.codigo)
			return false;
		if (editable != other.editable)
			return false;
		if (libro == null) {
			if (other.libro != null)
				return false;
		} else if (!libro.equals(other.libro))
			return false;
		if (numero != other.numero)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Capitulo [codigo=" + codigo + ", numero=" + numero + ", titulo=" + titulo + ", libro=" + libro
				+ ", autor=" + autor + ", editable=" + editable + "]";
	}

	 
	
	
   
}
