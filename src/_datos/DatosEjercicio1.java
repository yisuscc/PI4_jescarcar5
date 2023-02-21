package _datos;

import java.util.List;
import java.util.Map;

public class DatosEjercicio1 {
// un tipo  variedad cafe y otro tipo cafe
	public static record tipoCafe(Integer id, String nombre, Integer peso) {
		
	}
	
	public static record variedadCafe(Integer id, String nombre, Double beneficio, Map<String, Double> composicion) {
		
	}
	private static List<tipoCafe> cafe;
	private static List<variedadCafe>variedades;
	public static String cafeId(Integer id) {
		return cafe.get(id).nombre();
	}
	public static String variedadId(Integer id) {
		return variedades.get(id).nombre();
	} 
	// nint tipos cafe
	public static Integer getTiposCafe() {
		return cafe.size();
	}
	
	// int var cafe
	public static Integer getVarCafe() {
		return variedades.size();
	}
	// cantidad
	public static List<tipoCafe> getCafes() {
		return cafe;
	}
	public static List<variedadCafe> getVariedades(){
		return variedades;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
