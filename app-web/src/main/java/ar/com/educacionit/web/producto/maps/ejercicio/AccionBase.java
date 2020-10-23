package ar.com.educacionit.web.producto.maps.ejercicio;

import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.impl.ProductoServiceImpl;

public abstract class AccionBase {

	protected ProductoService productoService;
	
	public AccionBase() {
		this.productoService = new ProductoServiceImpl();
	}

	public ProductoService getProductoService() {
		return productoService;
	}

	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}
	
}
