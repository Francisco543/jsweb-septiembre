package ar.com.educacionit.web.producto;

import java.util.Scanner;

import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.exeptions.ServiceException;
import ar.com.educacionit.service.impl.ProductoServiceImpl;

public class DeleteProducto {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese el id a eliminar");
		
		Long id = teclado.nextLong();
		
		//interfaz nombre = new clase
		
		ProductoService productoService = new ProductoServiceImpl();
		
		try {
			productoService.eliminarProducto(id);
			System.out.println("Se ha eliminado el producto correctamente");
		} catch (ServiceException e) {
			e.printStackTrace();
		}finally {
			teclado.close();
		}
	}
}
