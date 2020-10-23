package ar.com.educacionit.web.producto.maps.ejercicio;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.service.exeptions.ServiceException;

public class MapaMain {

	public static void main(String[] args) throws ServiceException {
		
		//f3
		//ctrl+t
		Map<Integer, IAccion> acciones = contruirMapaAcciones();
		
		//alt+shift+m
		Scanner teclado = new Scanner(System.in);
		
		
		Integer opcion;
		do {
			System.out.println("Ingrese un accion:");
			System.out.println("1 - Nuevo");
			System.out.println("2 - Eliminar");
			opcion = teclado.nextInt();
		}while(opcion < 1 || opcion >2);

		//una valida!
		
		IAccion accion = acciones.get(opcion);
		Producto producto =  accion.execute(teclado);
		if(producto != null) {
			System.out.println("Accion" + accion.getClass().getSimpleName() + " ejecutada exitosamente!");
		}
		
	}

	private static Map<Integer, IAccion> contruirMapaAcciones() {
		//creo el map
		Map<Integer, IAccion> mapaAcciones = new HashMap<>();

		//cargamos el mapa con nuestras acciones
		Nuevo accionesNuevo = new Nuevo();		
		mapaAcciones.put(1, accionesNuevo);
		
		Eliminar accionesEliminar = new Eliminar();
		mapaAcciones.put(2, accionesEliminar);
		
		return mapaAcciones;
	}

}
