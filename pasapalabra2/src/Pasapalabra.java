import java.util.Scanner;

public class Pasapalabra {
	
	private static Pasapalabra miPasapalabra = new Pasapalabra();

	private Pasapalabra(){
}
	
	public static Pasapalabra getMiPasapalabra(){
		return miPasapalabra;
	}
	
	public static void empezarPartida(){

		Scanner sc = new Scanner(System.in);
		boolean salir = false;

		while (salir == false){
		Rosco miRosco = AlmacenPreguntas.dameUnRosco();
		miRosco.empezarPartida();
		System.out.println("Quieres volver a jugar? (si/no)");
		if(sc.next().equals("no"))
		{
			salir = true;
		}
		}
	}
}
