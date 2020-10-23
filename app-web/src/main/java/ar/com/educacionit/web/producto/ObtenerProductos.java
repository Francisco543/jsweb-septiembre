package ar.com.educacionit.web.producto;

import java.util.Collection;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.exeptions.ServiceException;
import ar.com.educacionit.service.impl.ProductoServiceImpl;

public class ObtenerProductos {

	public static void main(String[] args) throws ServiceException {
	
		ProductoService productoService = new ProductoServiceImpl();
		
		Collection<Producto> productos = productoService.obtenerProductos();

		//un 10%
		if(!productos.isEmpty()) {
			for(Producto producto : productos) {
				Float precio = producto.getPrecio();
				precio = precio *= 1.1f;
				producto.setPrecio(precio);
			}
		}
		
		//update masivo
		for(Producto producto : productos) {
			productoService.actualizarProducto(producto);
		}
	}

}
