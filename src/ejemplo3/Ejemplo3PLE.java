package ejemplo3;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import _datos.DatosAlumnos;
import _datos.DatosAlumnos.Alumno;
import _datos.DatosSubconjunto;
import ejemplo2.Ejemplo2PLE;
import us.lsi.gurobi.GurobiLp;
import us.lsi.gurobi.GurobiSolution;
import us.lsi.solve.AuxGrammar;

public class Ejemplo3PLE {
public static List<Alumno> alumnos;

public static Integer getNumAlumnos() {
	return alumnos.size();
}
public static Integer getNumGrupos() {
	return alumnos.get(0).afinidades().size();
}
public static Integer getAfinidad(Integer i, Integer j) {
	return alumnos.get(i).getAfinidad(j);
}
public static Integer getTamGrupo() {
	return getNumAlumnos()/getNumGrupos();
}
public static void ejemplo3_model() throws IOException{
	for(int ej= 1 ; ej<= 1; ej++) {
		System.out.println("Ejecutando el fichero numero: " + ej);
	DatosAlumnos.iniDatos("ficheros/Ejemplo3DatosEntrada"+ej+".txt");
	alumnos = DatosAlumnos.getAlumnos();
	AuxGrammar.generate(Ejemplo3PLE.class,"lsi_models/Ejemplo3.lsi","gurobi_models/Ejemplo3-"+ej+".lp");
	GurobiSolution solution = GurobiLp.gurobi("gurobi_models/Ejemplo3-"+ej+".lp");
	Locale.setDefault(new Locale("en", "US"));
	System.out.println(solution.toString((s,d)->d>0.));
	}
}
	public static void main(String[] args) throws IOException {
		ejemplo3_model();

	}

}
