package _datos;

import java.util.List;

import org.jgrapht.Graph;

import us.lsi.ag.SeqNormalData;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.grafos.datos.Ciudad;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;
import us.lsi.graphs.views.IntegerVertexGraphView;

public class DatosEjercicio4ALT implements SeqNormalData<List<_datos.DatosEjercicio4ALT.Cliente2>>{
	
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
private static IntegerVertexGraphView<Cliente2, Arista> grafo;
private static Integer n;




	public static void iniDatos(String fichero) {
		Graph<Cliente2, Arista> gra = GraphsReader.newGraph(fichero,Cliente2::create ,Arista::create, Graphs2::simpleWeightedGraph, Arista::kms);
		grafo= IntegerVertexGraphView.of(gra);
		n = gra.vertexSet().size();
		
	}
	private static void test() {
		iniDatos("ficheros/ejercicios/Ejercicio4DatosEntrada1.txt");
		System.out.println(grafo);
	}
	public static void main(String[] args) {
		test();

	}
	@Override
	public ChromosomeType type() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Double fitnessFunction(List<Integer> value) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Cliente2> solucion(List<Integer> value) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer itemsNumber() {
		// TODO Auto-generated method stub
		return null;
	}

}
