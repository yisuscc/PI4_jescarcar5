package ejercicio1;

import _datos.DatosEjercicio1;

public class ejercicio1PLE {
public static Integer tiposCafe;
public static Integer variedadesCafe;
public static Integer getTiposCafe() {
	return DatosEjercicio1.getTiposCafe();
}
public static Integer getVariedadesCafe() {
	
	return DatosEjercicio1.getVarCafe();
}
public static Integer getCantidad(Integer j) {
	
	return DatosEjercicio1.getCafes().get(j).peso();
}
public static Double getBeneficio(Integer i) {
	
	return DatosEjercicio1.getVariedades().get(i).beneficio();
}
public static Double getPorcentajeCafe(Integer i , Integer j) {
	
	return DatosEjercicio1.getVariedades().get(i).composicion().get(DatosEjercicio1.cafeId(j));
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
