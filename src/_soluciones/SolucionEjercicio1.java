package _soluciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import _datos.DatosEjercicio1;
import _datos.DatosEjercicio1.variedadCafe;
import us.lsi.common.List2;
import us.lsi.common.Pair;
import us.lsi.gurobi.GurobiSolution;



public class SolucionEjercicio1 {

	private Double beneficio;
	private List<Integer>  solucion; 
	/*
	 * no se si usar una lista de integer o una lista de Pair  Variedad,Integer
	 * de lista de pair variedad cafe integer pasa a integer, es redundante
	 */
	public static  SolucionEjercicio1 of_Range(List<Integer> values) {
		return new SolucionEjercicio1(values);
	}
	private  SolucionEjercicio1(List<Integer> values) {
		Double benTotal= 0.0;
		List<Integer> ls = List2.empty();
		for(int i = 0; i<values.size();i++) {
		variedadCafe vari = DatosEjercicio1.getVariedades().get(i);
		Double  ben=  vari.beneficio();
		benTotal += ben*values.get(i);
		ls.add(values.get(i));
		
		}
		this.beneficio = benTotal;
		this.solucion = ls;
	}
	public static  SolucionEjercicio1 create(GurobiSolution gs) {
		
		return new SolucionEjercicio1(gs.objVal,gs.values);
	}
	private SolucionEjercicio1(Double objVal, Map<String, Double> values) {
		List<Integer> ls = new ArrayList<>();
		for(Map.Entry<String, Double>par : values.entrySet()) {
			if(par.getKey().startsWith("x")) {
				
				Integer i = par.getValue().intValue();
				ls.add(i);
			}
			
		}
		solucion = ls;
		beneficio = objVal;
	}

	


	@Override
	public String toString() {
		String aux = " Variedades seleccionadas: \r\n ";
		// System.lineSeparator()
		List<Integer> sol = this.solucion;
		for(int j=0; j<sol.size(); j++) {
			Integer val = sol.get(j);
			if(val>0) {
				
				aux += DatosEjercicio1.getVariedades().get(j).nombre() +": "+ val +"\r\n";
			}
	
		}
		aux += "Beneficio: " +beneficio;
		return aux;
	}

}
