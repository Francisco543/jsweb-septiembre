package ar.com.educacionit.web.producto.maps.ejercicio;

import java.util.Scanner;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.service.exeptions.ServiceException;

public class Nuevo extends AccionBase implements IAccion {

	public Nuevo() {
		super();
	}
	
	@Override
	public Producto execute(Scanner teclado) throws ServiceException {
		
		//logica de lectura de datos desde el teclado
		
		System.out.println("Ingresar código:");
		String codigo = teclado.next();
		
		System.out.println("Ingresar titulo");
		String titulo = teclado.next();
		
		System.out.println("Ingresar precio");
		teclado.next();
		Float precio = teclado.nextFloat();
		
		System.out.println("Ingresar tipo producto");
		// 1
		// 2
		Long tipoProducto = teclado.nextLong();
		Producto nuevoProducto = new Producto(titulo, precio, codigo,tipoProducto);
		teclado.close();
		return this.productoService.nuevoProducto(nuevoProducto);
	}
	
}
