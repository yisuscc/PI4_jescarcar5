package ejercicio1;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import _datos.DatosEjercicio1;
import _datos.DatosEjercicio1.tipoCafe;
import _datos.DatosEjercicio1.variedadCafe;
import _soluciones.SolucionEjercicio1;
import ejemplo1.Ejemplo1PLE;
import us.lsi.gurobi.GurobiLp;
import us.lsi.gurobi.GurobiSolution;
import us.lsi.solve.AuxGrammar;

public class ejercicio1PLE {
public static Integer tiposCafe;
public static Integer variedadesCafe;
public static List<tipoCafe> cafe;
public static List<variedadCafe> variedades;

public static Integer getTiposCafe() {
	return DatosEjercicio1.getTiposCafe();
}
public static Integer getVariedadesCafe() {
	
	return DatosEjercicio1.getVarCafe();
}
public static Integer getCantidad(Integer j) {
	
	return DatosEjercicio1.getCafes().get(j).peso();
}
public static Double getBeneficio(Integer i) {
	
	return DatosEjercicio1.getVariedades().get(i).beneficio();
}
public static Double getPorcentajeCafe(Integer i , Integer j) {
	variedadCafe aux = DatosEjercicio1.getVariedades().get(i);
	String nomCaf = cafe.get(j).nombre();
	return aux.composicion().containsKey(nomCaf)?aux.composicion().get(nomCaf):0.0;
	
}
public static void entrada1() throws IOException {
	for(int ej= 1;ej<=3;ej++) {
		
		DatosEjercicio1.iniDatos("ficheros/ejercicios/Ejercicio1DatosEntrada"+ej+".txt");
		cafe = DatosEjercicio1.getCafes();
		variedades = DatosEjercicio1.getVariedades();
		AuxGrammar.generate(ejercicio1PLE.class,"lsi_models/ejercicio1.lsi","gurobi_models/ejercicio1-"+ej+".lp");
		GurobiSolution solution = GurobiLp.gurobi("gurobi_models/ejercicio1-"+ej+".lp");
		Locale.setDefault(new Locale("en", "US"));
		//System.out.println(solution.toString((s,d)->d>0.));
		System.out.println(SolucionEjercicio1.create(solution).toString());
	}

}
	public static void main(String[] args) throws IOException {
		
		entrada1();
	

	}

}
