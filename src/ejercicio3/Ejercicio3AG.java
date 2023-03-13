package ejercicio3;

import java.util.Iterator;
import java.util.List;

import _datos.DatosEjercicio3;
import _datos.DatosEjercicio3.Investigador;
import _datos.DatosEjercicio3.Trabajo;

import _soluciones.SolucionEjercicio3;
import us.lsi.ag.ValuesInRangeData;
import us.lsi.ag.ValuesInSetData;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.hypergraphs2.Datos;

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
		for(int t = 0; t<nTrabajos;t++) {//perspectiva de los trabajos
			Double dT = 0.0;
			Double trabajoNecesita = Double.valueOf(DatosEjercicio3.getDiaTrabajo(t));
			for(int in = 0; in<nInv; in++) {
				Integer posicion = in*nTrabajos+ t;
				dT += value.get(posicion);
			}
			
			if(dT>=trabajoNecesita) {
				calidadTotal += DatosEjercicio3.getTrabajos().get(t).calidad();
					
				}else if(dT>0) {
					error+= Math.abs(dT-trabajoNecesita);
				}
			}
		for(int in = 0; in<nInv; in++) {//perspectiva de los investigadores
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
