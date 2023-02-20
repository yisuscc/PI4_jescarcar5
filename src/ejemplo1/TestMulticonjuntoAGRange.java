package ejemplo1;

import java.util.List;
import java.util.Locale;

import _soluciones.SolucionMulticonjunto;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agstopping.StoppingConditionFactory;

public class TestMulticonjuntoAGRange {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("en", "US"));
		
		AlgoritmoAG.ELITISM_RATE  = 0.10;
		AlgoritmoAG.CROSSOVER_RATE = 0.95;
		AlgoritmoAG.MUTATION_RATE = 0.8;
		AlgoritmoAG.POPULATION_SIZE = 1000;
		
		StoppingConditionFactory.NUM_GENERATIONS = 1000;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionFactory.StoppingConditionType.GenerationCount;
		//Hacer un bucle
		List<String> ls = List.of("ficheros/Ejemplo1DatosEntrada1.txt",
				"ficheros/Ejemplo1DatosEntrada2.txt",
				"ficheros/Ejemplo1DatosEntrada3.txt");
		for(String f : ls) {
			InRangeMulticonjuntoAG p = new InRangeMulticonjuntoAG(f );
			
			
			AlgoritmoAG<List<Integer>,SolucionMulticonjunto> ap = AlgoritmoAG.of(p);
			ap.ejecuta();
			

			System.out.println("================================");
			System.out.println(ap.bestSolution());
			System.out.println("================================");
		}
		
	}
}
