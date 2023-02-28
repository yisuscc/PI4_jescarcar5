package _soluciones;

import java.util.List;

import _datos.DatosEjercicio1;
import _datos.DatosEjercicio1.variedadCafe;
import us.lsi.common.List2;
import us.lsi.common.Pair;



public class SolucionEjercicio1 {

	private Double beneficio;
	private List<Pair<variedadCafe, Integer>>  solucion; 
	/*
	 * no se si usar una lista de integer o una lista de Pair  Variedad,Integer
	 */
	public static  SolucionEjercicio1 of_Range(List<Integer> values) {
		return new SolucionEjercicio1(values);
	}
	private  SolucionEjercicio1(List<Integer> values) {
		Double benTotal= 0.0;
		List<Pair<variedadCafe, Integer>> ls = List2.empty();
		for(int i = 0; i<values.size();i++) {
		variedadCafe vari = DatosEjercicio1.getVariedades().get(i);
		Double  ben=  vari.beneficio();
		benTotal += ben*values.get(i);
		ls.add(Pair.of(vari,values.get(i)));
		
		}
		this.beneficio = benTotal;
		this.solucion = ls;
	}
	


	@Override
	public String toString() {
		String aux = " Variedades seleccionadas: \r\n ";
		// System.lineSeparator()
		for(Pair<variedadCafe, Integer> i : this.solucion) {
			if(i.second()>0) {
				
				aux += i.first().nombre() +": "+ i.second() +"\r\n";
			}
	
		}
		aux += "Beneficio: " +beneficio;
		return aux;
	}

}
