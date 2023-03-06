package ejercicio3;

import java.util.List;

import _datos.DatosAlumnos;
import _datos.DatosMulticonjunto;
import _soluciones.SolucionAlumnos;
import _soluciones.SolucionMulticonjunto;

import us.lsi.ag.ValuesInRangeData;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;


public class InRangeAlumnosAG  
implements ValuesInRangeData<Integer, SolucionAlumnos>{

	public InRangeAlumnosAG(String linea) {
		DatosAlumnos.iniDatos(linea);
	}

	public static void main(String linea) {
		

	}

	@Override
	public Integer size() {
	
		return DatosAlumnos.getNumAlumnos();
	}

	@Override
	public ChromosomeType type() {
	
		return ChromosomeType.Range;
	}

	@Override
	public Double fitnessFunction(List<Integer> value) {
		double  goal = 0.0, error = 0.0;
		int[]v = new int[DatosAlumnos.getNumAlumnos()];
		for(int i = 0; i<value.size();i++) {
			v[value.get(i)]++;
			Integer  a= DatosAlumnos.getAfinidad(i, value.get(i));
			if (a>0)
				goal+=a;
			else
				error++;
		}
		for(int e :v) {
			error += e!=DatosAlumnos.getTamGrupo()?1:0;
		}
		
		
		
		return goal -10000*error;
	}

	@Override
	public SolucionAlumnos solucion(List<Integer> value) {
		
		SolucionAlumnos res = SolucionAlumnos.empty();
		for(int i = 0; i<value.size();i++) {
			res.add(i, value.get(i));
		}
		return res;
	}

	@Override
	public Integer max(Integer i) {
		
		return DatosAlumnos.getNumGrupos();
	}

	@Override
	public Integer min(Integer i) {
		
		return 0;
	}

}
