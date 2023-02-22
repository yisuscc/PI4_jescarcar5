package _datos;

import java.util.HashMap;
import java.util.Map;

public class DatosEjercicio3 {
//INV1: capacidad=10; especialidad=0;
//T01 -> calidad=7; reparto=(0:2),(1:0),(2:5),(3:0);
public static record Investigador (String nombre, Integer capacidad, Integer especialidad) {
	public static Investigador create(String linea) {
		String []datos = linea.split(";");
		String nom =  datos[0].trim();
		Integer cap = Integer.valueOf(datos[1].trim());
		Integer esp = Integer.valueOf(datos[2].trim());
		return new Investigador(nom, cap, esp);
	}
}
public static record Trabajo(String nombre, Integer calidad, Map<Integer,Integer>espDias) {
	public static Trabajo create(String linea) {
		String []datos = linea.split(";");
		String[] aux = datos[0].split("->");
		String nom =  aux[0].trim();
		Integer cal = Integer.valueOf(aux[1].replace("calidad=", "").trim());
		Map<Integer , Integer> eD = new HashMap<>();
		String
		for()
		
	}
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
