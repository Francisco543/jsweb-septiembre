package ar.com.educacionit.web.producto;

import java.util.Scanner;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.exeptions.ServiceException;
import ar.com.educacionit.service.impl.ProductoServiceImpl;

public class ActualizarProducto {

	public static void main(String[] args) throws ServiceException {
		
		//paso1
		ProductoService productoService = new ProductoServiceImpl();
		
		//obtener un producto
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese el ID producto a buscar");
		
		Long id = teclado.nextLong();
		
		Producto producto = productoService.obtenerProductoById(id);
		
		//tendria que leer titulo, precio y tipo de producto
		
		System.out.println("Ingrese precio");
		Float precio = teclado.nextFloat();

		System.out.println("Ingrese tituo");
		teclado.next();
		String titulo = teclado.nextLine();
		
		producto.setTitulo(titulo);
		producto.setPrecio(precio);
		
		System.out.println("Actualizando....");
		producto = productoService.actualizarProducto(producto);
		
		teclado.close();
	}

}
