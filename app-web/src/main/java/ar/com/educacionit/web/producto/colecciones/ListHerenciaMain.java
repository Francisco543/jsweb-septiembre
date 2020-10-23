package ar.com.educacionit.web.producto.colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListHerenciaMain {

	public static void main(String[] args) {
		
		List<Mujer> mujeres = new ArrayList<>();
		
		List<Hombre> hombres = new ArrayList<>();
		
		List<Humano> humanos = new ArrayList<Humano>();
		
		//cargar la lista con humanos
		for(int i=0;i<10;i++) {
			
			if(i%2==0) {//par
				mujeres.add(new Mujer());
			}else {
				hombres.add(new Hombre());
			}
		}

		Iterator itHumanos = mujeres.iterator();
		
		while(itHumanos.hasNext()) {
			Mujer mujer = (Mujer)itHumanos.next();
		}
	}

}
