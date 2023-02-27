package ejercicio4;

import java.util.List;

import _datos.DatosEjercicio4;
import _datos.DatosEjercicio4.Cliente;
import us.lsi.ag.SeqNormalData;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;

public class ejercicio4AG implements SeqNormalData<List<Cliente>> {
public ejercicio4AG( String fichero) {
	DatosEjercicio4.iniDatos();
}
	@Override
	public ChromosomeType type() {
		// TODO Auto-generated method stub
		return ChromosomeType.Permutation;
	}

	@Override
	public Double fitnessFunction(List<Integer> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> solucion(List<Integer> value) {
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
