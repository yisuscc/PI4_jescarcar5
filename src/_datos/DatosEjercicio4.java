package _datos;

import org.jgrapht.Graph;

public class DatosEjercicio4 {
	
	//asumo que es un grafo no dirigido
	// pero ponderado
public static record Cliente(Integer idCliente,Double beneficio ) {
	public static Cliente create(String linea) {
		//0,0.
		String[] aux = linea.split(",");
		return new Cliente(Integer.valueOf(aux[0].trim()), Double.valueOf(aux[1].trim()));
	}
}
public static record Arista(Integer idCliente1, Integer idCliente2,Double kms) {
	public static  Arista create(String linea) {
		//0,1,1.0
		String[] aux = linea.split(",");
		return new Arista(Integer.valueOf(aux[0].trim()),Integer.valueOf(aux[1].trim()),Double.valueOf(aux[1].trim()));
	}
}
private static Graph<Cliente, Arista> grafo;

public static Graph<Cliente, Arista> getGrafo(){
	return grafo;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void iniDatos() {
		// TODO Auto-generated method stub
		
	}

}
