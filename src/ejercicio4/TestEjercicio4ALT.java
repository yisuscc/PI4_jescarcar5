package ejercicio4;

import java.util.List;
import java.util.Locale;

import ejercicio4.DatosEjercicio4ALT.Cliente2;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agstopping.SolutionsNumber;
import us.lsi.ag.agstopping.StoppingConditionFactory;


public class TestEjercicio4ALT {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("en", "US"));
		AlgoritmoAG.ELITISM_RATE  = 0.10;
		AlgoritmoAG.CROSSOVER_RATE = 0.70;
		AlgoritmoAG.MUTATION_RATE = 0.7;
		AlgoritmoAG.POPULATION_SIZE = 500;
		StoppingConditionFactory.NUM_GENERATIONS = 1000;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionFactory.StoppingConditionType.GenerationCount;
		for(int i = 1; i<=2;i++) {
			String fichero = "ficheros/ejercicios/Ejercicio4DatosEntrada"+i+".txt";
			DatosEjercicio4ALT p = new DatosEjercicio4ALT(fichero);
			AlgoritmoAG<List<Integer>, List<Cliente2>> ap= AlgoritmoAG.of(p);
			ap.ejecuta();
			System.out.println("================================");
			System.out.println("El mejor cromosoma es" );
			List<Integer> dc = ap.getBestChromosome().decode();
			System.out.println(dc);
			System.out.println("El fitness es:");
			System.out.println(ap.getBestChromosome().fitness());
		
			System.out.println("El recorrido es:"+ap.bestSolution().stream().map(v->v.idCliente()).toList());
			System.out.println("================================");
			System.out.println(SolutionsNumber.numeroDeGeneraciones);
		}
	}

}
