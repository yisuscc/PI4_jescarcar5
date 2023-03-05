package ejercicio3;

import java.util.Iterator;
import java.util.List;

import _datos.DatosEjercicio3;
import _datos.DatosEjercicio3.Investigador;
import _datos.DatosEjercicio3.Trabajo;
import _datos.DatosEjercicio4;
import _soluciones.SolucionEjercicio3;
import us.lsi.ag.ValuesInRangeData;
import us.lsi.ag.ValuesInSetData;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;

public class Ejercicio3AG implements ValuesInSetData<SolucionEjercicio3> {

	public Ejercicio3AG(String string) {
		DatosEjercicio3.iniData(string);
	}
	// para obtener el trabajo se usa el mod ntrabajos
			//para obtener el investigador div entera ntrabajos
	/*
	 * 	Trabajo trab =DatosEjercicio3.getTrabajos().get( i%nTrabajos);
			Investigador inv = DatosEjercicio3.getInvestigadores().get(i/nTrabajos);
	 */
	//private static Integer nInv = DatosEjercicio3.getInvestigadores().size();
//	private static Integer nTrabajos =  DatosEjercicio3.getTrabajos().size();
	@Override
	public Integer size() {
		Integer nTrabajos =  DatosEjercicio3.getTrabajos().size();
		Integer nInv = DatosEjercicio3.getInvestigadores().size();
		return nInv*nTrabajos;
	}
	@Override
	public Double fitnessFunction(List<Integer> value) {
		Integer nTrabajos =  DatosEjercicio3.getTrabajos().size();
		Integer nInv = DatosEjercicio3.getInvestigadores().size();
		Double calidadTotal= 0.0;
		Double error= 0.0;
		for(int k = 0; k<nTrabajos;k++) {
			Double dT = 0.0;
			for(int l = k;l<value.size();l = l+nTrabajos) {
				dT += value.get(l);
			}
			if(dT>0.0) {
			calidadTotal += DatosEjercicio3.getTrabajos().get(k).calidad();
				
			}
		}
		for(int in = 0; in<nInv; in++) {
			Integer diasTrabajados =0;
			for(int t = 0; t<nTrabajos;t++) {
				Integer posicion = in*nTrabajos+ t;
			diasTrabajados +=	value.get(posicion);
			}
			Integer capacidad = DatosEjercicio3.getInvestigadores().get(in).capacidad();
			if(diasTrabajados>capacidad) {
				error += Math.abs(diasTrabajados-capacidad)*100;
			}
			
		}
		return calidadTotal -1000*error*error;
	}
	@Override
	public SolucionEjercicio3 solucion(List<Integer> value) {
		
		return new SolucionEjercicio3(value);
	}
	@Override
	public List<Integer> values(Integer i) {
		Integer nTrabajos =  DatosEjercicio3.getTrabajos().size();
		Integer nInv = DatosEjercicio3.getInvestigadores().size();
		Trabajo trab =DatosEjercicio3.getTrabajos().get( i%nTrabajos);
		Investigador inv = DatosEjercicio3.getInvestigadores().get(i/nTrabajos);
		Integer diaEsp = trab.espDias().get(inv.especialidad());
		return List.of(0,diaEsp);
	}

}
