package ejercicio2;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import _datos.DatosEjercicio2;
import _datos.DatosEjercicio2.Cursos;

import _soluciones.SolucionEjercicio2;
import us.lsi.ag.BinaryData;
import us.lsi.common.Set2;

public class Ejercicio2AGBIN implements BinaryData<SolucionEjercicio2> {

	public Ejercicio2AGBIN(String fichero) {
		DatosEjercicio2.iniDatos(fichero);
	}

	@Override
	public Integer size() {
		
		return DatosEjercicio2.getCursos().size();
	}

	@Override
	public Double fitnessFunction(List<Integer> value) {
		// minimizar el precio de la incripción
		
	Double error = 0.0;
	Double precioTotal =  0.0;
	Set<Integer> setTematicas = DatosEjercicio2.getCursos().
			stream().flatMap(c-> c.tematica().
					stream()).collect(Collectors.toSet()) ;
	Integer nTematicas = setTematicas.size();
	Integer maxCent = DatosEjercicio2.getMaxCentros();
	Set<Integer> centrosEscogidos = Set2.empty();
	Set<Integer> tematicasEscogidas = Set2.empty();
	for(int i = 0; i<value.size(); i++) {
		Cursos cursoI = DatosEjercicio2.getCursos().get(i);
		precioTotal += value.get(i)* cursoI.matricula();
		
		centrosEscogidos.add(cursoI.centro());
		tematicasEscogidas.addAll(cursoI.tematica());
		
	}
		//se deben cubri todas las tematicas 
		if(!tematicasEscogidas.containsAll(setTematicas)) {
			/* Uso la duiferencia en lugar de una penalización directa 
			 * para diferenciar entre cromosomas cercanos a ser solución
			 * y cromosomas deistantes de ser solución
			 * aunque si no se quiere hacer la distinción, se puede quitar y ya esta 
			 *
			 * Se puede hacer de muchas maneras la penalizació de esta restricción
			 * la diferencia en valor absoluto  multiplicada por un numero muy grande 
			 * la dferencia elevada a una numero par multiplicado por un numero grande
			 * entre otras opciones
			 */
			error += Math.abs(nTematicas-tematicasEscogidas.size()) *10;
			
		}
		//no se puede elegir mas de un numero determinado de ce4ntros diferentes 
		if(centrosEscogidos.size()>maxCent) {
			error += Math.abs(centrosEscogidos.size()-maxCent) *10;
			
		}

		return -precioTotal -100*(error*error);
	}

	@Override
	public SolucionEjercicio2 solucion(List<Integer> value) {
		
		return SolucionEjercicio2.create(value);
	}

}
