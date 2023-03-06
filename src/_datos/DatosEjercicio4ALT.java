package _datos;

import java.util.List;

import org.jgrapht.Graph;

import us.lsi.ag.SeqNormalData;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.common.List2;

import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;
import us.lsi.graphs.views.IntegerVertexGraphView;

public class DatosEjercicio4ALT implements SeqNormalData<List<_datos.DatosEjercicio4ALT.Cliente2>>{
	public DatosEjercicio4ALT(String fichero) {
		iniDatos(fichero);
	}
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
		//System.out.println(grafo);
		System.out.println(grafo.vertex(0));
	}
	public static void main(String[] args) {
		test();

	}
	@Override
	public ChromosomeType type() {
		
		return ChromosomeType.Permutation;
	}
	@Override
	public Double fitnessFunction(List<Integer> value) {
		//el beneficio es siempre el mismo
		Double beneficio = grafo.vertexSet().stream().mapToDouble(s-> grafo.vertex(s).beneficio()).sum();
		Double kms = 0.0;
		Double penalizacion = 0.0;
		Double penalizaciónkms= 0.01;
		Double error = 0.0;
		// el pirmer indice debe de ser cero 
		if(!value.get(0).equals(0)) {
			error += 1000;
		}
		// deben existir aristas entre los vertices
		for(int i = 0; i<value.size();i++) {
			Integer j = (i+1)%n;
			if(!grafo.containsEdge(value.get(i), value.get(j))) {
				error += 1000;
			}else {
			penalizacion = 2*penalizacion+ grafo.getEdgeWeight(value.get(i), value.get(j));	
			
			}
		}
		//debe existir una arista entre el vertice final y el almacen
		if(!grafo.containsEdge(0, value.get(value.size()-1))) {
			error+=100;
		}
		
		return beneficio-penalizacion*penalizaciónkms-10000*(error*error);
	}
	@Override
	public List<Cliente2> solucion(List<Integer> value) {
		List<Cliente2> res = List2.of(grafo.vertex(0));
		res.addAll(0, value.stream().map(v-> grafo.vertex(v)).toList());
		return res;
	}
	@Override
	public Integer itemsNumber() {
		
		return n;
	}

}
