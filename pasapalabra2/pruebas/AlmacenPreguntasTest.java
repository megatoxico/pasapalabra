import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AlmacenPreguntasTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetMiAlmacen() {
		assertNotNull(AlmacenPreguntas.getMiAlmacen());
	}

	@Test
	public void testDameUnRosco() {
		assertNotNull(AlmacenPreguntas.dameUnRosco());
		/*HAY QUE PROBAR:
		 * que nos da un rosco de 26 preguntas.
		 * que el orden de las preguntas es correcto
		 * que cada pregunta tiene texto y respuesta.
		 * que tiempo aciertos y fallos se actualiza correctamente.
		 */
		
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
		
	}

}
