package ejercicio4;

import java.util.List;

import _datos.DatosEjercicio4;

import us.lsi.ag.SeqNormalData;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;

public class ejercicio4AG implements SeqNormalData<List<Integer>> {
public ejercicio4AG( String fichero) {
	DatosEjercicio4.iniDatos(fichero);
}
	@Override
	public ChromosomeType type() {
		
		return ChromosomeType.Permutation;
	}

	@Override
	public Double fitnessFunction(List<Integer> value) {
		Double benenficio = 0.0;
		Double perdida = 0.0;
		Double penRet = 0.01;
		Double kmRec= 0.0;
		Double error = 0.0;
		if(!value.get(0).equals(0)) {
			//esta rtestricción se puede implenetar en el items number creo
			// o bien se puede hacer una reiterpretación de la lista
			//es decir el valor de la lista.get(i) mas 1 y al  intems number le restamos 1 
			error = error +100;
		}
		for(int i = 0; i<value.size(); i++) {
			
		}
		return null;
	}

	@Override
	public List<Integer> solucion(List<Integer> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer itemsNumber() {
		// TODO Auto-generated method stub
		// no se si hay  que sumarle 1
		return DatosEjercicio4.getGrafo().vertexSet().size();
	}

}
