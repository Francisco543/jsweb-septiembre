package ar.com.educacionit.web.producto.maps.ejercicio;

import java.util.Scanner;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.service.exeptions.ServiceException;

public class Eliminar extends AccionBase implements IAccion{

	public Eliminar() {
		super();
	}
	
	//ctrl+spac
	@Override
	public Producto execute(Scanner teclado) throws ServiceException {
		
		System.out.println("Ingresar id del producto a eliminar");

		Long id = teclado.nextLong();
		
		this.productoService.eliminarProducto(id);
		
		teclado.close();
		
		return null;
	}
}
