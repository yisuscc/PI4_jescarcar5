package _soluciones;

import java.util.List;

import _datos.DatosEjercicio3;
import us.lsi.common.List2;

public class SolucionEjercicio3 {
	private static  List<Integer> sol;
	private static Integer calidad;
	 //private static Integer nInv = DatosEjercicio3.getInvestigadores().size();
	// private static Integer nTrabajos = DatosEjercicio3.getTrabajos().size();
	public SolucionEjercicio3(List<Integer> value) {
		Integer calidadTotal= 0;
		Integer nTrabajos = DatosEjercicio3.getTrabajos().size();
		Integer nInv = DatosEjercicio3.getInvestigadores().size();
		for(int k = 0; k<nTrabajos;k++) {
			Double dT = 0.0;
			for(int l = k;l<value.size();l = l+nTrabajos) {
				dT += value.get(l);
			}
			if(dT>0.0) {
			calidadTotal += DatosEjercicio3.getTrabajos().get(k).calidad();
				
			}
		}
		sol = value;
		calidad = calidadTotal;
	}

	@Override
	public String toString() {
		String s = "Reparto obtenido: \r\n";
		Integer nTrabajos = DatosEjercicio3.getTrabajos().size();
		Integer nInv = DatosEjercicio3.getInvestigadores().size();
		Integer inicio = 0;
		Integer fin = nTrabajos;
		for(int i = 0; i<nInv;i++) {
			List<Integer> solu = List2.copy(sol.subList(inicio, fin));
			s += "INV"+i+": " +solu +"\r\n";
			inicio+=nTrabajos;
			fin += nTrabajos;
		}
		s += "Suma de las calidades: " +calidad;
		return s;
	}
	

}
