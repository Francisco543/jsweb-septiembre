package ar.com.educacionit.web.producto.colecciones;

import java.util.Comparator;
import java.util.TreeSet;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.web.producto.colecciones.comprator.MayorPrecio;
import ar.com.educacionit.web.producto.colecciones.comprator.MenorPrecio;

public class TreeSetMain {

	public static void main(String[] args) {
	
		String orden = args[0];
		
		Comparator<Producto> interfazOrden;
		if(Integer.parseInt(orden) == 1) {
			interfazOrden = new MenorPrecio();
		}else {
			interfazOrden = new MayorPrecio();
		}
		
		//alt+shit+r
		TreeSet<Producto> productos = new TreeSet<Producto>(interfazOrden);
		
		//del 1 al 10
		for(int i=0;i<10;i++) {
			
			Producto producto = new  Producto("titulo"+i, new Float(1000+i),"00"+i);
			
			productos.add(producto);
		}
		
		//System.out.println(productos);
		
		//mostrar-->foreach
		for(Producto producto : productos) {
			System.out.println(producto);
		}
	}

}
