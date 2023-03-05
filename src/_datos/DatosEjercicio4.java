package _datos;

import org.jgrapht.Graph;

import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;

public class DatosEjercicio4 {
	
	//asumo que es un grafo no dirigido
	// pero ponderado


	public static record Cliente2(Integer idCliente,Double beneficio ) {
		public static Cliente2 create(String[] aux) {
			//0,0.
			//String[] aux = linea.split(",");
			return new Cliente2(Integer.valueOf(aux[0].trim()), Double.valueOf(aux[1].trim()));
		}
	}
	public static record Arista(Integer idCliente1, Integer idCliente2,Double kms) {
		public static  Arista create(String[] aux) {
			//0,1,1.0
			//String[] aux = linea.split(",");
			return new Arista(Integer.valueOf(aux[0].trim()),Integer.valueOf(aux[1].trim()),Double.valueOf(aux[1].trim()));
		}
	}
private static Graph<Cliente2, Arista> grafo;

public static Graph<Cliente2, Arista> getGrafo(){
	return grafo;
}
public static Cliente2 devVertice(Integer j) {
	return grafo.vertexSet().stream().filter(v-> v.idCliente.equals(j)).findFirst().get();
}
public static Boolean tieneArista(Integer i, Integer j) {
	
	return ;
}
public static Double pesoArista(Integer i, Integer j) {
	Double r = 1000;
	if (grafo.containsEdge(devVertice(i),devVertice(j))) {
		r= grafo.getEdgeWeight(grafo.getEdge(devVertice(i), devVertice(j)));
	}
	return r; 
}

	public static void iniDatos(String fichero) {
		Graph<Cliente2, Arista> gra = GraphsReader.newGraph(fichero,Cliente2::create ,Arista::create, Graphs2::simpleWeightedGraph, Arista::kms);
		grafo= gra;
		
	}
	private static void test() {
		iniDatos("ficheros/ejercicios/Ejercicio4DatosEntrada1.txt");
		System.out.println(grafo);
	}
	public static void main(String[] args) {
		test();

	}

}
