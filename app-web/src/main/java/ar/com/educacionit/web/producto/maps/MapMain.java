package ar.com.educacionit.web.producto.maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapMain {
	
	public static void main(String[] args) {
		
		Map<Integer, String> DiasDeLaSemana = new HashMap<Integer, String>();
		
		DiasDeLaSemana.put(1, "Lunes");
		DiasDeLaSemana.put(2, "Martes");
		DiasDeLaSemana.put(3, "Miercoles");
		DiasDeLaSemana.put(4, "Jueves");
		DiasDeLaSemana.put(5, "Viernes");
		DiasDeLaSemana.put(6, "Sabado");
		DiasDeLaSemana.put(7, "Domingo");
		
		
		System.out.println(DiasDeLaSemana.get(7));
		
		
		//Recorrer las claves
		Set<Integer> keys=DiasDeLaSemana.keySet();
		
		for(Integer key : keys) {
			System.out.println(key);
		}
		
		//Recorrer los valores
		Collection<String> values = DiasDeLaSemana.values();
		for(String value: values) {
			System.out.println(value);
		}
		
		Iterator<String> itValues = values.iterator();
		while(itValues.hasNext()) {
			String value = itValues.next();
			System.out.println(value);
		}
		
		//Dadas las keys tomo los valores:
		
		keys = DiasDeLaSemana.keySet();
		
		for(Integer key : keys) {
			if(key==7){
				DiasDeLaSemana.put(key,"Sunday");
			}
			
			String valorDado= DiasDeLaSemana.get(key);
			System.out.println("Clave: " + key + " " + "Valor dado: " + valorDado);
		}
		
		Set<Entry<Integer,String>> entrySet = DiasDeLaSemana.entrySet();
		for(Entry<Integer,String> entry : entrySet) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + ", " + value);
		}
		
	}

}
