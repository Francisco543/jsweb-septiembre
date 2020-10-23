package ar.com.educacionit.web;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.exeptions.ServiceException;
import ar.com.educacionit.service.impl.ProductoServiceImpl;

public class CRUDProductoMain {

	public static void main(String[] args) {

		ProductoService productoService = new ProductoServiceImpl();
		
		try {
			Producto producto =  productoService.obtenerProductoById(1L);
			
			System.out.println(producto);
			
		} catch (ServiceException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

}
