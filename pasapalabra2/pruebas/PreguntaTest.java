import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PreguntaTest {

	Pregunta unaPregunta, otraPregunta;
	
	@Before
	public void setUp() throws Exception {
		unaPregunta = new Pregunta('a',"texto","respuesta");
		otraPregunta = new Pregunta('h',"hexto","hespuesta");
	}

	@After
	public void tearDown() throws Exception {
		unaPregunta = null;
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
		assertFalse(unaPregunta.esCorrecta("nada"));
	}

	@Test
	public void testGetRespuesta() {
		assertEquals(unaPregunta.getRespuesta(),"respuesta");
	}

	@Test
	public void testGetLetra() {
		assertEquals(unaPregunta.getLetra(),'a');
		assertEquals(otraPregunta.getLetra(),'h');
	}

	@Test
	public void testImprimir() {
		System.out.println("Se tiene que imprimir:\n" +
				"Empieza con la a :\n" +
				"texto\n" +
				"\nY el programa escribe:\n");
		unaPregunta.imprimir();
	}

}
