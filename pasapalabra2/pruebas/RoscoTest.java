import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class RoscoTest {
	
	Rosco unRosco;
	ListaPreguntas unaLista;
	Pregunta unaPregunta;
	
	@Before
	public void setUp() throws Exception {
		unaPregunta = new Pregunta('h',"estado del agua al congelarse","helada");
		unaLista = new ListaPreguntas();
		unaLista.anadirPregunta(unaPregunta);
		unRosco = new Rosco(unaLista);
	}

	@After
	public void tearDown() throws Exception {
		unRosco = null;
		unaLista = null;
		unaPregunta = null;
	}

	@Test
	public void testRosco() {
	unRosco = null;
	unRosco = new Rosco(unaLista);
	assertNotNull(unRosco);
	}

	@Test
	public void testEmpezarPartida() {
		fail("Not yet implemented");
	}

}
