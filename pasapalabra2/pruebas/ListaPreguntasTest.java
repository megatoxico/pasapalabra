import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ListaPreguntasTest {

	ListaPreguntas unaLista;
	
	@Before
	public void setUp() throws Exception {
		unaLista = new ListaPreguntas();
	}

	@After
	public void tearDown() throws Exception {
		unaLista = null;
	}

	@Test
	public void testListaPreguntas() {
		unaLista=null;
		unaLista = new ListaPreguntas();
		assertNotNull(unaLista);
	}

	@Test
	public void testAnadirPregunta() {
		Pregunta unaPregunta = new Pregunta('m',"texto","melocoton");
		unaLista.anadirPregunta(unaPregunta);
		Pregunta otraPregunta = unaLista.sacarPregunta();
		assertTrue(otraPregunta.esCorrecta("melocoton"));
	}

	@Test
	public void testSacarPregunta() {
		Pregunta unaPregunta = new Pregunta('m',"texto","melocoton");
		unaLista.anadirPregunta(unaPregunta);
		Pregunta otraPregunta = unaLista.sacarPregunta();
		assertTrue(otraPregunta.esCorrecta("melocoton"));
	}

	@Test
	public void testQuedanPreguntas() {
		Pregunta unaPregunta = new Pregunta('m',"texto","melocoton");
		unaLista.anadirPregunta(unaPregunta);
		assertTrue(unaLista.quedanPreguntas());
		unaLista.sacarPregunta();
		assertFalse(unaLista.quedanPreguntas());
	}

}
