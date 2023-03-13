package ejercicio2;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import _datos.DatosEjercicio1;
import _datos.DatosEjercicio2;
import _datos.DatosEjercicio2.Cursos;
import ejercicio1.ejercicio1PLE;
import us.lsi.gurobi.GurobiLp;
import us.lsi.gurobi.GurobiSolution;
import us.lsi.solve.AuxGrammar;

public class ejercicio2PLEBoolean {
	private static List<Cursos> Cursos;
	private static Integer maxCentros;
	
public static Integer getCursos() {
	
	return Cursos.size();
}
public static Integer  getTematicas() {
	
	return Cursos.stream().map(c-> c.tematica()).flatMap(s-> s.stream()).collect(Collectors.toSet()).size();
}
public static Integer getCentros() {
	
	return Cursos.stream().map(c-> c.centro()).collect(Collectors.toSet()).size();
}
public static Integer getMaxCentros() {

	return DatosEjercicio2.getMaxCentros();
}
public static Integer getCursoTematica(Integer i, Integer j) {
	
	return Cursos.get(i).tematica().contains(j)?1:0;
}
public static Double getPrecio (Integer i) {

	return  Cursos.get(i).matricula();
}
public static Boolean getCursoCentro(Integer i, Integer k) {
	
	return Cursos.get(i).centro().equals(k);
}
public static void entrada1() throws IOException {
	for(int ej = 1 ; ej<= 3; ej++) {
		
		DatosEjercicio2.iniDatos("ficheros/ejercicios/Ejercicio2DatosEntrada"+ej+".txt");
		Cursos = DatosEjercicio2.getCursos();
		maxCentros = DatosEjercicio2.getMaxCentros();
		System.out.println(DatosEjercicio2.getCursos());;
		//ñSystem.out.println(getTematicas());
		AuxGrammar.generate(ejercicio2PLEBoolean.class,"lsi_models/ejercicio2Boolean.lsi","gurobi_models/ejercicio2Bool-"+ej+".lp");
		GurobiSolution solution = GurobiLp.gurobi("gurobi_models/ejercicio2Bool-"+ej+".lp");
		Locale.setDefault(new Locale("en", "US"));
		System.out.println(solution.toString((s,d)->d>0.));
	}

}
	public static void main(String[] args) throws IOException {
		entrada1();

	}

}
