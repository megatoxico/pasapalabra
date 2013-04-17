import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PasapalabraTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetMiPasapalabra() {
		assertNotNull(Pasapalabra.getMiPasapalabra());
	}

	@Test
	public void testEmpezarPartida() {
		System.out.println("Verifica que te deja jugar otra partida cuando se acaba una.");
		Pasapalabra.empezarPartida();
	}

}
