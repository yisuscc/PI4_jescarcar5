package ejercicio3;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import _datos.DatosEjercicio3;
import _soluciones.SolucionEjercicio3;
import us.lsi.ag.ValuesInRangeData;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;

public class Ejercicio3AGInRange implements ValuesInRangeData<Integer, SolucionEjercicio3> {

	public Ejercicio3AGInRange(String fichero) {
		
		DatosEjercicio3.iniData(fichero);
	}

	@Override
	public Integer size() {
		
		return DatosEjercicio3.getTrabajos().size()*DatosEjercicio3.getInvestigadores().size();
	}

	@Override
	public ChromosomeType type() {
		return ChromosomeType.Range;
	}

	@Override
	public Double fitnessFunction(List<Integer> value) {
		Integer nTrabajos =  DatosEjercicio3.getTrabajos().size();
		Integer nInv = DatosEjercicio3.getInvestigadores().size();
		Double calidadTotal = 0.0, error= 0.0;
		// un trabajador no puede exceder su capacidad
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
		
		// un trabajo tiene que tener la cantidad de dias de su especialidad  necesaria
		for(int t= 0; t<nTrabajos; t++) {
//			que los dias trabajados sean nos que necesita
			Integer sum = 0;
			Integer calidad = DatosEjercicio3.getTrabajos().get(t).calidad();
			Integer dTT = 0;
			Integer diasNecesariosT = DatosEjercicio3.getDiaTrabajo(t);
			//primero que loas trabajos tengan todos los dias suficietes por esp
			Map<Integer, Integer> esPDias = DatosEjercicio3.getTrabajos().get(t).espDias();
			for(Entry<Integer, Integer> esp: esPDias.entrySet()) {// creo que con un entry set queda mas legible
				Integer dTEsp = 0;
				Integer diasNecesariosEsp = esp.getValue();
				Integer es = esp.getKey();
				for(int in = 0; in<nInv; in++) {
					Integer posicion = in*nTrabajos+ t;
					Boolean b = DatosEjercicio3.getInvestigadores().get(in).especialidad().equals(es);
					if(b) {
						dTEsp += value.get(posicion);
						dTT+= value.get(posicion);
						
					}
						
					
				}
				if(dTEsp!=0 && dTEsp != diasNecesariosEsp) {
					// penaliza tanto solo si le falta
					error += Math.abs(dTEsp-diasNecesariosEsp);
				}
			}
			if(dTT>= diasNecesariosT) {
				calidadTotal += calidad;
			}else if(dTT != 0) {
				error += Math.abs(diasNecesariosT-dTT);
			}
		}
		// 
		
		return  calidadTotal-100*(error*error);
	}

	@Override
	public SolucionEjercicio3 solucion(List<Integer> value) {
		
		return new SolucionEjercicio3(value);
	}
	@Override
	public Integer max(Integer i) {
	//	 * 	Trabajo trab =DatosEjercicio3.getTrabajos().get( i%nTrabajos);
	//	Investigador inv = DatosEjercicio3.getInvestigadores().get(i/nTrabajos);
		Integer nTrabajos = DatosEjercicio3.getTrabajos().size();
		Integer trab = i%nTrabajos;
		Integer inv = i/ nTrabajos;
		return Math.min(DatosEjercicio3.getInvestigadores().get(inv).capacidad(),
				DatosEjercicio3.getDiaTrabajoInv(trab, inv))+1;
	}

	@Override
	public Integer min(Integer i) {
		
		return 0;
	}

}
