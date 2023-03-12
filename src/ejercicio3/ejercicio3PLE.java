package ejercicio3;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import _datos.DatosEjercicio3;
import _datos.DatosEjercicio3.Investigador;
import _datos.DatosEjercicio3.Trabajo;
import ejemplo1.Ejemplo1PLE;
import us.lsi.gurobi.GurobiLp;
import us.lsi.gurobi.GurobiSolution;
import us.lsi.solve.AuxGrammar;

public class ejercicio3PLE {
	private static List<Investigador> investigadores;
	private static List<Trabajo> trabajos ;
	
	public static Integer getInvestigadores() {
		return investigadores.size();
	}
	public static Integer getEspecialidades() {
		return investigadores.stream().
				map(i-> i.especialidad()).
				collect(Collectors.toSet()).size();
	}
	public static Integer getTrabajos() {
		return trabajos.size();
	}
	public static Integer getTrabajadorEsp(Integer i, Integer k) {
		return investigadores.get(i).especialidad().equals(k)?1:0;
	}
	public static Integer getDiasDisp(Integer i) {
	 return investigadores.get(i).capacidad();
	}
	public static Integer getDiasNecesarios(Integer j, Integer k) {
		return trabajos.get(j).espDias().get(k);
	}
	public static Integer getCalidadTrabajo(Integer j) {
		return trabajos.get(j).calidad();
	}
	public static Integer getDiasInvTrabajo(Integer i, Integer j) {
		Integer esp = investigadores.get(i).especialidad();
		return getDiasNecesarios(j, esp);
	}
public static void entrada1() throws IOException {
	String fichero = "ficheros/ejercicios/Ejercicio3DatosEntrada1.txt";
	DatosEjercicio3.iniData(fichero);
	investigadores = DatosEjercicio3.getInvestigadores();
	trabajos = DatosEjercicio3.getTrabajos();
	AuxGrammar.generate(ejercicio3PLE.class,"lsi_models/ejercicio3.lsi","gurobi_models/ejercicio3-1.lp");
	GurobiSolution solution = GurobiLp.gurobi("gurobi_models/ejercicio3-1.lp");
	Locale.setDefault(new Locale("en", "US"));
	System.out.println(solution.toString((s,d)->d>0.));
}
	public static void main(String[] args) throws IOException {
	entrada1();

	}

}
