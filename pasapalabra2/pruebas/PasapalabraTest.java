import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PasapalabraTest {

	private static Pasapalabra miPasapalabra;
	
	@Before
	public void setUp() throws Exception {
		miPasapalabra = Pasapalabra.getMiPasapalabra();
	}

	@After
	public void tearDown() throws Exception {
		miPasapalabra = null;
	}

	@Test
	public void testGetMiPasapalabra() {
		assertNotNull(Pasapalabra.getMiPasapalabra());
	}

	@Test
	public void testEmpezarPartida() {
		System.out.println("Verifica que te deja jugar otra partida cuando se acaba una.");
		miPasapalabra.jugar();
	}

}
