package ejercicio1;

import java.util.List;
import java.util.Locale;

import _soluciones.SolucionEjercicio1;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agstopping.StoppingConditionFactory;

public class TestEjercicio1 {
 public static void main(String[] args) {
	 Locale.setDefault(new Locale("en", "US"));
		
		AlgoritmoAG.ELITISM_RATE  = 0.10;
		AlgoritmoAG.CROSSOVER_RATE = 0.95;
		AlgoritmoAG.MUTATION_RATE = 0.8;
		AlgoritmoAG.POPULATION_SIZE = 1000;
		
		StoppingConditionFactory.NUM_GENERATIONS = 1000;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionFactory.StoppingConditionType.GenerationCount;
		List<String> ls = List.of("ficheros/ejercicios/Ejercicio1DatosEntrada1.txt");
		for(String s : ls) {
			ejercicio1AG p = new ejercicio1AG(s);
			AlgoritmoAG<List<Integer>, SolucionEjercicio1> ap = AlgoritmoAG.of(p);
			ap.ejecuta();
			

			System.out.println("================================");
			System.out.println(ap.bestSolution());
			System.out.println("================================");
			
		}
}
}
