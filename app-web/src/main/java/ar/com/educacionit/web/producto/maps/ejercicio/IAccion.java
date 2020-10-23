package ar.com.educacionit.web.producto.maps.ejercicio;

import java.util.Scanner;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.service.exeptions.ServiceException;

public interface IAccion {

	public Producto execute(Scanner teclado) throws ServiceException;
}
