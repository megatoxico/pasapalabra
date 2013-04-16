
public class Pasapalabra {
	
//no hace falta:	private Rosco miRosco;
	private static Pasapalabra miPasapalabra = new Pasapalabra();
	
	private Pasapalabra(){
	// no hace falta: miRosco = null; 
}
	
	public static Pasapalabra getMiPasapalabra(){
		return miPasapalabra;
	}
	
	public void empezarPartida(){
		Rosco miRosco = null;
		miRosco = AlmacenPreguntas.dameUnRosco();
		miRosco.empezarPartida();
	}
}
