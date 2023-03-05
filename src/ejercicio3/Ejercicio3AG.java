package ejercicio3;

import java.util.Iterator;
import java.util.List;

import _datos.DatosEjercicio3;
import _datos.DatosEjercicio3.Investigador;
import _datos.DatosEjercicio3.Trabajo;
import _datos.DatosEjercicio4;
import _soluciones.SolucionEjercicio3;
import us.lsi.ag.ValuesInRangeData;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;

public class Ejercicio3AG implements ValuesInRangeData<Integer, SolucionEjercicio3> {
	private static Integer nInv = DatosEjercicio3.getInvestigadores().size();
	private static Integer nTrabajos = DatosEjercicio3.getTrabajos().size();
	@Override
	public Integer size() {
		/*
		 * la posicion es la siguiente 
		 * in*nTrabajos+trabajo =posicion 
		 */
		return nInv*nTrabajos;
	}

	@Override
	public ChromosomeType type() {
		
		return ChromosomeType.Range;
	}

	@Override
	public Double fitnessFunction(List<Integer> value) {
	// para obtener el trabajo se usa el mod ntrabajos
		//para obtener el investigador div entera ntrabajos
		Double fitness;
		Integer calidadTotal = 0.0;
		// suma de las calidades
		
	
		for(int k = 0;k<nTrabajos; k++) {
//			este bucle obtiene la suma de las calids de los trabajos selecconados 
			boolean escogeTrabajo = false;
			for(int j = k; j<value.size();j= j+nTrabajos) {
				if(value.get(j)>0) {
					escogeTrabajo= true;
				}
		}
			if(escogeTrabajo)
				calidadTotal += DatosEjercicio3.getTrabajos().get(k).calidad();
	}
		for(int q = 0; q<nInv ; q++) {
			//este bucle clacula la disponibilidad de cada trabajador
			
			
		}
		for(int i= 0;i<value.size();i++ ) {
			Trabajo trab =DatosEjercicio3.getTrabajos().get( i%nTrabajos);
			Investigador inv = DatosEjercicio3.getInvestigadores().get(i/nTrabajos);
			if(trab.espDias().contain))
		}
		
		return fitness;
	}

	@Override
	public SolucionEjercicio3 solucion(List<Integer> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer max(Integer i) {
		
		return ;
	}

	@Override
	public Integer min(Integer i) {
		
		return 0;
	}

}
