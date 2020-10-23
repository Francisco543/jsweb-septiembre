package ar.com.educacionit.web.producto;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exeptions.DuplicatedException;
import ar.com.educacionit.dao.exeptions.GenericDAOException;
import ar.com.educacionit.domain.Producto;

public class NuevoProducto {

	public static void main(String[] args) {
		
		Producto nuevoProducto = new Producto("TERMO LUMILAGRO", new Float(1500), "0001", new Long(2));
		
		boolean succes = false;

		int reintentos = 3;
		while(!succes && reintentos > 0) {
			try {
				ProductoDAO pdao = new ProductoDAO();
				pdao.createProducto(nuevoProducto);
				succes = true;
			} catch (DuplicatedException e) {
				System.out.println("No se pudo crear el producto, ya existe la codigo: " + nuevoProducto.getCodigo());
				nuevoProducto.setCodigo("0004");
			} catch (GenericDAOException e) {
				System.out.println("No se pudo crear el producto, error inesperado por favor reintente");
			}
			reintentos--;
		}
		if(!succes || reintentos == 0) {
			System.out.println("No se ha podido crear el producto, por favor verique con sistemas");
		}else {
			System.out.println(nuevoProducto);			
		}
	}

}
