package _soluciones;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import _datos.DatosEjercicio2;
import _datos.DatosEjercicio2.Cursos;

public class SolucionEjercicio2 {



private static Double coste;
private static Set<String> cursos;

private SolucionEjercicio2(List<Integer> values) {
	Double cost = 0.0;
	Set<String> cur = new HashSet<>();
	
	for(int i = 0; i<values.size(); i++) {
		if(values.get(i)==1) {
			Cursos cursoI = DatosEjercicio2.getCursos().get(i);
			cost += cursoI.matricula();
			cur.add("S"+i);
		}
	}
	this.cursos = cur;
	this.coste = cost;
	
}
public static SolucionEjercicio2 create(List<Integer>  values) {
	return new SolucionEjercicio2(values);
}



	@Override
public String toString() {
	return "Cursos elegidos: "+this.cursos +"\r\n"+"Coste total: "+this.coste+"\r\n";
}
	

}
