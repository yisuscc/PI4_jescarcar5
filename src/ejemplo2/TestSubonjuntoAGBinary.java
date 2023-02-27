package ejemplo2;

import java.util.List;
import java.util.Locale;

import _soluciones.SolucionMulticonjunto;
import _soluciones.SolucionSubconjunto;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agstopping.StoppingConditionFactory;

public class TestSubonjuntoAGBinary {

	public static void main(String[] args) {
	Locale.setDefault(new Locale("en", "US"));
		
		AlgoritmoAG.ELITISM_RATE  = 0.30;
		AlgoritmoAG.CROSSOVER_RATE = 0.80;
		AlgoritmoAG.MUTATION_RATE = 0.7;
		AlgoritmoAG.POPULATION_SIZE = 50;
		
		StoppingConditionFactory.NUM_GENERATIONS = 1000;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionFactory.StoppingConditionType.GenerationCount;
		for(int ej= 1; ej<= 2; ej++) {
		BinSubconjuntoAG p = new BinSubconjuntoAG("ficheros/Ejemplo2DatosEntrada"+ej+".txt");
		AlgoritmoAG<List<Integer>,SolucionSubconjunto> ap = AlgoritmoAG.of(p);
		ap.ejecuta();
		

		System.out.println("================================");
		System.out.println(ap.bestSolution());
		System.out.println("================================");
		}
	}

}
