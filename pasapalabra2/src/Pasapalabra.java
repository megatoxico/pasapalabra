import java.util.Scanner;

public class Pasapalabra {
	
	private static Pasapalabra miPasapalabra = new Pasapalabra();
	
	
	
	
	private Pasapalabra(){
}
	
	public static Pasapalabra getMiPasapalabra(){
		return miPasapalabra;
	}
	
	   /** Sitio del que leer las líneas de entrada */
    IfzScanner scanner = new IfzScanner() {
        private final Scanner scanner = new Scanner(System.in);
        public String nextLine() {
            return scanner.nextLine();
        }
    };

    // Implementacion de IfzMuestraResultados, que escribe en pantalla
    IfzMuestraResultados muestraResultados = new IfzMuestraResultados() {
        public void println(String textoPeticion) {
            System.out.println(textoPeticion);
        }
    };
	
    /** Se le pasa por donde mostrar los resultados */
    public void setIfzMuestraResultados(IfzMuestraResultados muestraResultados) {
        this.muestraResultados = muestraResultados;
    }

    /** Se le pasa de dónde leer las entradas */
    public void setIfzScanner(IfzScanner scanner) {
        this.scanner = scanner;
    }
	
	public void jugar(){
		Intro miIntro =new Intro();
		miIntro.animar();
		boolean salir = false;
		String respuesta = null;
		AlmacenPreguntas miAlmacenPreguntas = AlmacenPreguntas.getMiAlmacen();
		
		while (salir == false){
		Rosco miRosco = miAlmacenPreguntas.dameUnRosco();
		miRosco.empezarPartida();
		muestraResultados.println("Quieres volver a jugar? (si/no)");
		try
		{
		respuesta = scanner.nextLine();
		if(respuesta.equals("no") || respuesta.equals("No") || respuesta.equals("NO"))
		{
			throw new SalirJuegoExcepcion("quiere salir");
		}
		}
		catch (SalirJuegoExcepcion e)
		{
			muestraResultados.println("Hasta pronto.");
			//System.exit(0);
			return;
		}
	}
}
}
