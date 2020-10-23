package ar.com.educacionit.domain;

public class Producto implements Comparable<Producto>{

	private Long id;
	
	private String titulo;
	
	private Float precio;
	
	private String codigo;
	
	private Long tipoProducto;

	public Producto(Long id, String titulo, Float precio, String codigo) {
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.codigo = codigo;
	}
	
	public Producto(String titulo, Float precio, String codigo, Long tipoProducto) {
		this.titulo = titulo;
		this.precio = precio;
		this.codigo = codigo;
		this.tipoProducto = tipoProducto;
	}
	
	//alt+shift+s

	public Producto(String titulo, Float precio, String codigo) {
		this.titulo = titulo;
		this.precio = precio;
		this.codigo = codigo;
	}

	public Producto(Long id, String titulo, Float precio, String codigo, Long tipoProducto) {
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.codigo = codigo;
		this.tipoProducto = tipoProducto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", codigo=" + codigo + "]";
	}

	public Long getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(Long tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Producto other = (Producto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(Producto otroProducto) {
		// 1 - 2 ->  ---   < 0
		// 1 -1 ->  == 0
		// 2 - 1 -> > 0
		
		//FLOAT
		//DOUBLE
		//INTEGER
		//STRING  A  a ASCCI
		//BOOLEAN
		//LONG
		return otroProducto.getPrecio().compareTo(this.getPrecio());
	}	
	
	//alt+shift+s
	
}
