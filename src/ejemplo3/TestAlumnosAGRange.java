package ejemplo3;

import java.util.List;
import java.util.Locale;

import _soluciones.SolucionAlumnos;
import _soluciones.SolucionMulticonjunto;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agstopping.StoppingConditionFactory;

public class TestAlumnosAGRange {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("en", "US"));
		
		AlgoritmoAG.ELITISM_RATE  = 0.30;
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.MUTATION_RATE = 0.7;
		AlgoritmoAG.POPULATION_SIZE = 50;
		
		StoppingConditionFactory.NUM_GENERATIONS = 5000;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionFactory.StoppingConditionType.GenerationCount;
		//Hacer un bucle
		List<String> ls = List.of("ficheros/Ejemplo3DatosEntrada1.txt",
				"ficheros/Ejemplo3DatosEntrada2.txt",
				"ficheros/Ejemplo3DatosEntrada3.txt");
		for(String f : ls) {
			InRangeAlumnosAG p = new InRangeAlumnosAG(f );
			
			
			AlgoritmoAG<List<Integer>,SolucionAlumnos> ap = AlgoritmoAG.of(p);
			ap.ejecuta();
			

			System.out.println("================================");
			System.out.println(ap.bestSolution());
			System.out.println("================================");
		}
		
	}
}
