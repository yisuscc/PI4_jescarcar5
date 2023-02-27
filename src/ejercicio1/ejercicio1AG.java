package ejercicio1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import _datos.DatosEjercicio1;
import _datos.DatosEjercicio1.tipoCafe;
import _datos.DatosEjercicio1.variedadCafe;
import us.lsi.ag.ValuesInRangeData;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;

public class ejercicio1AG implements ValuesInRangeData<Integer, SoluciónEj1>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer size() {
		// TODO Auto-generated method stub
		return DatosEjercicio1.getVarCafe();
	}

	@Override
	public ChromosomeType type() {
		// TODO Auto-generated method stub
		return ChromosomeType.Range;
	}
	private static Double getPorcentajeCafe(Integer i , Integer j) {
		variedadCafe aux = DatosEjercicio1.getVariedades().get(i);
		return aux.composicion().containsKey(j)?aux.composicion().get(j):0.0;
	}

	@Override
	public Double fitnessFunction(List<Integer> value) {
		Double error = 0.0;
		Double valor = 0.0;
		Double fitness = null;
		for (int i = 0; i<value.size(); i++) {
		
			Double beneficio = value.get(i)*DatosEjercicio1.getVariedades().get(i).beneficio();
			valor += beneficio ;
			
		}
		for (int i = 0; i<value.size(); i++) {
			
		}
		
		return null;
	}
	
	@Override
	public SoluciónEj1 solucion(List<Integer> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer max(Integer i) {
	Map<String, Double >mapAux= 	DatosEjercicio1.getVariedades().get(i).composicion();
	Set<String>setAux = mapAux.keySet();
	Comparator<tipoCafe> tc = Comparator.comparing(tipoCafe::peso);
	tipoCafe cafeLimite = DatosEjercicio1.getCafes().stream().filter(c->setAux.contains(c) ).min(tc).get();
	
	return   (int) (cafeLimite.peso()/mapAux.get(cafeLimite));
	}

	@Override
	public Integer min(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
