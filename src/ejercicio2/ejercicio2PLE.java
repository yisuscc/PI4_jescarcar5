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

public class ejercicio2PLE {
	private static List<Cursos> Cursos;
	private static Integer maxCentros;
	
public static Integer getCursos() {
	
	return DatosEjercicio2.getCursos().size();
}
public static Integer  getTematicas() {
	
	return DatosEjercicio2.getCursos().stream().map(c-> c.tematica()).flatMap(s-> s.stream()).collect(Collectors.toSet()).size();
}
public static Integer getCentros() {
	
	return DatosEjercicio2.getCursos().stream().map(c-> c.centro()).collect(Collectors.toSet()).size();
}
public static Integer getMaxCentros() {

	return DatosEjercicio2.getMaxCentros();
}
public static  Boolean getCursoTematica(Integer i, Integer j) {
	
	return DatosEjercicio2.getCursos().get(i).tematica().contains(j);
}
public static Double getPrecio (Integer i) {

	return  DatosEjercicio2.getCursos().get(i).matricula();
}
public static Boolean getCursoCentro(Integer i, Integer k) {
	
	return DatosEjercicio2.getCursos().get(i).centro().equals(k);
}
public static void entrada1() throws IOException {
	DatosEjercicio2.iniDatos("ficheros/ejercicios/Ejercicio2DatosEntrada1.txt");
	Cursos = DatosEjercicio2.getCursos();
	maxCentros = DatosEjercicio2.getMaxCentros();
	//System.out.println(getCursoTematica(4, 0));;
	System.out.println(getTematicas());
	AuxGrammar.generate(ejercicio2PLE.class,"lsi_models/ejercicio2.lsi","gurobi_models/ejercicio2-1.lp");
	GurobiSolution solution = GurobiLp.gurobi("gurobi_models/ejercicio2-1.lp");
	Locale.setDefault(new Locale("en", "US"));
	System.out.println(solution.toString((s,d)->d>0.));
}
	public static void main(String[] args) throws IOException {
		entrada1();

	}

}
