package ejercicio1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import _datos.DatosEjercicio1;
import _datos.DatosEjercicio1.tipoCafe;
import _datos.DatosEjercicio1.variedadCafe;
import _soluciones.SolucionEjercicio1;
import us.lsi.ag.ValuesInRangeData;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;

public class ejercicio1AG implements ValuesInRangeData<Integer, SolucionEjercicio1> {

	public ejercicio1AG(String s) {
		DatosEjercicio1.iniDatos(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer size() {

		return DatosEjercicio1.getVarCafe();
	}

	@Override
	public ChromosomeType type() {

		return ChromosomeType.Range;
	}

	private static Double getPorcentajeCafe(Integer i, Integer j) {
		variedadCafe aux = DatosEjercicio1.getVariedades().get(i);
		String nomCaf = DatosEjercicio1.getCafes().get(j).nombre();
		return aux.composicion().containsKey(nomCaf) ? aux.composicion().get(nomCaf) : 0.0;

	}

	private static Double pesoTotalCafe(List<Integer> value, Integer cafe) {

		String nomCaf = DatosEjercicio1.getCafes().get(cafe).nombre();
		Double peso = 0.0;
		for (int i = 0; i < value.size(); i++) {
			variedadCafe aux = DatosEjercicio1.getVariedades().get(i);
			peso += aux.composicion().containsKey(nomCaf) ? aux.composicion().get(nomCaf) : 0.0;

		}
		return peso;
	}

	@Override
	public Double fitnessFunction(List<Integer> value) {
		Double error = 0.0;
		Double beneficio = 0.0;
		Integer pen = 0;
		for (int i = 0; i < value.size(); i++) {

			
			beneficio += value.get(i) * DatosEjercicio1.getVariedades().get(i).beneficio();;

		}

		for (int caf = 0; caf < DatosEjercicio1.getTiposCafe(); caf++) {
			 Double dif = DatosEjercicio1.getCafes().get(caf).peso()- pesoTotalCafe(value, caf);
			
			 if(dif<= 0) {
				 error += Math.abs(dif); 
				 pen = 1;
			 }

			

		}

		return beneficio - (1000000 *pen* error * error);
	}

	@Override
	public Integer max(Integer i) {
		Map<String, Double> mapAux = DatosEjercicio1.getVariedades().get(i).composicion();
		Set<String> setAux = mapAux.keySet();
		Double limite = setAux.stream().
				mapToDouble(k -> DatosEjercicio1.getCafeNom(k).peso()/ mapAux.get(k)).
				min().getAsDouble();

		return (int) Math.floor(limite) ;
	}

	@Override
	public Integer min(Integer i) {

		return 0;
	}

	@Override
	public SolucionEjercicio1 solucion(List<Integer> value) {

		return SolucionEjercicio1.of_Range(value);
	}

}
