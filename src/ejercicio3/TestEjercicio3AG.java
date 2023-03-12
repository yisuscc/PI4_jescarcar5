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
	// lo voy a hacer en test inndividuales, porque si no, me da problemas en la
	// visualización
	public static void test1() {

		// DatosEjercicio3.test(fichero);
		String fichero = "ficheros/ejercicios/Ejercicio3DatosEntrada1.txt";
		Ejercicio3AG p = new Ejercicio3AG(fichero);
		AlgoritmoAG<List<Integer>, SolucionEjercicio3> ap = AlgoritmoAG.of(p);
		ap.ejecuta();
		System.out.println("================================");
		System.out.println(ap.bestSolution());
		System.out.println("Fitness: ");
		System.out.println(ap.getBestChromosome().fitness());
		System.out.println("================================");
	}

	public static void test2() {
		String fichero = "ficheros/ejercicios/Ejercicio3DatosEntrada2.txt";

		Ejercicio3AG p = new Ejercicio3AG(fichero);
		AlgoritmoAG<List<Integer>, SolucionEjercicio3> ap = AlgoritmoAG.of(p);
		ap.ejecuta();

		System.out.println("================================");
		System.out.println(ap.bestSolution());
		System.out.println("Fitness: ");
		System.out.println(ap.getBestChromosome().fitness());
		System.out.println("================================");
	}

	public static void test3() {

		String fichero = "ficheros/ejercicios/Ejercicio3DatosEntrada3.txt";

		Ejercicio3AG p = new Ejercicio3AG(fichero);
		AlgoritmoAG<List<Integer>, SolucionEjercicio3> ap = AlgoritmoAG.of(p);
		ap.ejecuta();

		System.out.println("================================");
		System.out.println(ap.bestSolution());
		System.out.println("Fitness: ");
		System.out.println(ap.getBestChromosome().fitness());
		System.out.println("================================");
	}

	public static void main(String[] args) {

		// Importante ejecutar cada uno de forma Individual
		// si no da problemas en la presentación
		Locale.setDefault(new Locale("en", "US"));
		AlgoritmoAG.ELITISM_RATE = 0.30;
		AlgoritmoAG.CROSSOVER_RATE = 0.80;
		AlgoritmoAG.MUTATION_RATE = 0.7;
		AlgoritmoAG.POPULATION_SIZE = 500;
		StoppingConditionFactory.NUM_GENERATIONS = 1000;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionFactory.StoppingConditionType.GenerationCount;
		test1();
		test2();
		test3();

	}

}
