
public class PruebaPasapalabra {

	public static void main(String[] args) {
		/*Pregunta pregunta1 = new Pregunta('a',"opcion en euskera","aukera");
		Pregunta pregunta2 = new Pregunta('b',"barrio de bilbao","barakaldo");
		Pregunta pregunta3 = new Pregunta('c',"de la mar el mero y de la tierra el...","cordero");
		ListaPreguntas miListaPreguntas = new ListaPreguntas();
		miListaPreguntas.anadirPregunta(pregunta1);
		miListaPreguntas.anadirPregunta(pregunta2);
		miListaPreguntas.anadirPregunta(pregunta3);
		Rosco miRosco = new Rosco(miListaPreguntas);
		*/
		
		
		Rosco miRosco= AlmacenPreguntas.dameUnRosco("especial.dat");
		miRosco.empezarPartida();
		
		
		//Pasapalabra.empezarPartida();
	}

}
