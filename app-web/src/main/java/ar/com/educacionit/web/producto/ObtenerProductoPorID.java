package ar.com.educacionit.web.producto;

import java.util.Scanner;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.exeptions.ServiceException;
import ar.com.educacionit.service.impl.ProductoServiceImpl;

public class ObtenerProductoPorID {

	public static void main(String[] args) throws ServiceException {
	
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese el id a consultar");
		
		Long id = teclado.nextLong();
		
		teclado.close();

		ProductoService productoService = new ProductoServiceImpl();
		
		Producto productoBuscado = productoService.obtenerProductoById(id);

		if(productoBuscado != null) {  
			System.out.println("Producto encontrado: " + productoBuscado);
		}else {
			System.out.println("No existe Producto con id:" + id);
		}
	}

}
