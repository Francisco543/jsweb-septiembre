package ar.com.educacionit.web;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exeptions.DuplicatedException;
import ar.com.educacionit.dao.exeptions.GenericDAOException;
import ar.com.educacionit.dao.exeptions.NonExistException;
import ar.com.educacionit.domain.Producto;

public class ABMProductoMain {

	public static void main(String[] args) {
		
		String codigo = "0001" ;
		
		Float precio  = 1500f;
		
		String titulo = "IRON MAN3";
		
		try {
			
			Producto producto = new Producto(1001L, titulo, precio, codigo);
					
			ProductoDAO.createProducto(producto);
			
			ProductoDAO.deleteProducto(producto.getId());
			
			producto = new Producto(1001L, titulo, precio, "0002");
			
			ProductoDAO.createProducto(producto);
			
		} catch (DuplicatedException | GenericDAOException de) {
			de.printStackTrace();
		} catch (NonExistException nee) {
			nee.printStackTrace();
		}
	}

}
