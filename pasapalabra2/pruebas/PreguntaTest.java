import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PreguntaTest {

	Pregunta unaPregunta, otraPregunta;
	
	@Before
	public void setUp() throws Exception {
		unaPregunta = new Pregunta('a',"texto","respuesta");
		otraPregunta = new Pregunta('ñ',"texto","hespuesta");
	}

	@After
	public void tearDown() throws Exception {
		unaPregunta = null;
		otraPregunta = null;
	}

	@Test
	public void testPregunta() {
		unaPregunta = null;
		unaPregunta = new Pregunta('a',"texto","respuesta");
		assertNotNull(unaPregunta);
	}

	@Test
	public void testEsCorrecta() {
		assertTrue(unaPregunta.esCorrecta("respuesta"));
		assertTrue(unaPregunta.esCorrecta("Respuesta"));
		assertTrue(unaPregunta.esCorrecta("rEspUesTa"));
		assertTrue(unaPregunta.esCorrecta("réspúéstá"));
		assertFalse(unaPregunta.esCorrecta("nada"));
	}

	@Test
	public void testGetRespuesta() {
		assertEquals(unaPregunta.getRespuesta(),"respuesta");
	}

	@Test
	public void testGetLetra() {
		assertEquals(unaPregunta.getLetra(),'a');
		assertEquals(otraPregunta.getLetra(),'ñ');
	}

	@Test
	public void testImprimir() {
		System.out.println("Se tiene que imprimir:\n" +
				"Empieza con la a :\n" +
				"texto\n" +
				"\nY el programa escribe:\n");
		unaPregunta.imprimirTexto();
		System.out.println("\n\nSe tiene que imprimir:\n" +
				"Contiene la ñ :\n" +
				"texto\n" +
				"\nY el programa escribe:\n");
		otraPregunta.imprimirTexto();
	}

}
