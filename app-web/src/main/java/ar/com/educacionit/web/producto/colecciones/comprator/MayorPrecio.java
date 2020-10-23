package ar.com.educacionit.web.producto.colecciones.comprator;

import java.util.Comparator;

import ar.com.educacionit.domain.Producto;

public class MayorPrecio implements Comparator<Producto> {

	@Override
	public int compare(Producto producto1, Producto producto2) {
		return producto2.getPrecio().compareTo(producto1.getPrecio());
	}

}
