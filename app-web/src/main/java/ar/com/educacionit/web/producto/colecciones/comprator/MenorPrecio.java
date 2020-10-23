package ar.com.educacionit.web.producto.colecciones.comprator;

import java.util.Comparator;

import ar.com.educacionit.domain.Producto;

public class MenorPrecio implements Comparator<Producto> {

	@Override
	public int compare(Producto producto1, Producto producto2) {
		return producto1.getPrecio().compareTo(producto2.getPrecio());
	}

}
