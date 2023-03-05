package ejercicio3;

import java.util.List;
import java.util.Locale;

import _datos.DatosEjercicio3;
import _soluciones.SolucionEjercicio2;
import _soluciones.SolucionEjercicio3;
import ejercicio2.Ejercicio2AGBIN;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agstopping.StoppingConditionFactory;

public class TestEjercicio3AG {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("en", "US"));
		
		AlgoritmoAG.ELITISM_RATE  = 0.30;
		AlgoritmoAG.CROSSOVER_RATE = 0.80;
		AlgoritmoAG.MUTATION_RATE = 0.7;
		AlgoritmoAG.POPULATION_SIZE = 500;
		
		StoppingConditionFactory.NUM_GENERATIONS = 1000;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionFactory.StoppingConditionType.GenerationCount;
		for(int ej= 1; ej<= 3; ej++) {
		String fichero = "ficheros/ejercicios/Ejercicio3DatosEntrada"+ej+".txt";
		//DatosEjercicio3.test(fichero);
		Ejercicio3AG p = new Ejercicio3AG(fichero);
		AlgoritmoAG<List<Integer>,SolucionEjercicio3> ap = AlgoritmoAG.of(p);
		ap.ejecuta();
		

		System.out.println("================================");
		System.out.println(ap.bestSolution());
		System.out.println(ap.getBestChromosome().fitness());
		System.out.println("================================");
		}

	}

}
