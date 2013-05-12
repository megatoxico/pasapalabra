import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlmacenPreguntasTest {
	
    /** scanner específico para el test */
    private MockScanner scanner;
    /** MuestraResultados específico para el test */
    private MockMuestraResultados muestraResultados;
    private Rosco miRosco;
    private static AlmacenPreguntas miAlmacenPreguntas;
    
	@Before
	public void setUp() throws Exception {
        scanner = new MockScanner();
        muestraResultados = new MockMuestraResultados();
        miAlmacenPreguntas = AlmacenPreguntas.getMiAlmacen();
        miRosco = miAlmacenPreguntas.dameUnRosco("especial.dat");
        miRosco.setIfzScanner(scanner);
        miRosco.setIfzMuestraResultados(muestraResultados);
	}

	@After
	public void tearDown() throws Exception {
		miRosco = null;
		scanner = null;
		muestraResultados = null;
	}

	@Test
	public void testGetMiAlmacen() {
		assertNotNull(AlmacenPreguntas.getMiAlmacen());
	}

	@Test
	public void testDameUnRosco() {
/*PRUEBAS INICIALES SEMIAUTOMATICAS

		//Comprobamos que el rosco tiene 26 preguntas
		System.out.println("pulsando p para pasarpalabra, tienes que recorrer\n" +
				"todas las letras del abecedario en orden, y tienen que ser 26.\n" +
				"las 26 tienen que tener texto descriptivo que es un numero del 1 al 5\n" +
				"en la siguiente vuelta escribe cualquier cosa que no sea 1, para fallar\n" +
				"en todas las preguntas y comprobar que te da la respuesta correcta\n" +
				"en todas (1), comprueba tambien que el tiempo se va restando segun lo \n" +
				"que tardas en fallar la pregunta. Por ultimo comprueba tambien la aleatoriedad 1-4\n" +
				"de los textos de las preguntas del 1 al 5 y que al acertar cuenta el acierto.\n");
		Rosco miRosco = AlmacenPreguntas.dameUnRosco("especial.dat");
		miRosco.empezarPartida();
*/
	
		//PRUEBAS FINALES CON LOS INTERFACES DE SCANNER Y PRINTLN
		
        miRosco.empezarPartida();
        // Se comprueba que se han leido las dos lineas del scanner
        //assertEquals(4, scanner.getContador());
        // Se comprueba que han salido tres lineas por pantalla
        System.out.println(muestraResultados.getContador());
        assertEquals(63, muestraResultados.getContador());
		
		
		
	}

}
