package ar.com.educacionit.web.producto.colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
//ctrl+shift+o
public class ListContainMain {

	public static void main(String[] args) {
		String nombreUnico = "soy carlos";
		
		Collection<String> nombres = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			if(i%2==0) {
				nombres.add(nombreUnico);
			}else {
				nombres.add(nombreUnico+i);
			}
		}
		
		System.out.println("datos de la lista siendo List: " + nombres);
		//quitar los duplicados de una coleccion
		nombres = new HashSet<String>(nombres);
		
		System.out.println("datos de la lista siendo Set: " + nombres);
	}

}
