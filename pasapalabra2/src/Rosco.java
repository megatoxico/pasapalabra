
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Rosco {

	private ListaPreguntas laLista;
	private int fallos, aciertos;
	private long tiempoRestante;
	private ArrayList<Long> tiempos = new ArrayList<Long>();
	
    /** Sitio del que leer las l�neas de entrada */
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

    /** Se le pasa de d�nde leer las entradas */
    public void setIfzScanner(IfzScanner scanner) {
        this.scanner = scanner;
    }
	
	public Rosco(ListaPreguntas pListaPreguntas){
		this.laLista = pListaPreguntas;
		this.aciertos = 0;
		this.fallos = 0;
		this.tiempoRestante = 240000;
	}

	private void sumarAcierto(){
		this.aciertos++;
	}
	
	private void sumarFallo(){
		this.fallos++;
	}

	public int getAciertos(){
		return this.aciertos;
	}
	
	public int getFallos(){
		return this.fallos;
	}
	
	public long getTiempoRestante(){
		return this.tiempoRestante;
	}
	
	private void setTiempoRestante(long pTiempoRestante)
	{
		this.tiempoRestante = pTiempoRestante;
	}

	private ListaPreguntas getLista(){
		return this.laLista;
	}
	
	private int getMediaTiempos(){
		Iterator<Long> itr = tiempos.iterator();
		long tiempo = 0;
		int contador = 0;
		while (itr.hasNext())
		{
			tiempo = tiempo + itr.next();
			contador++;
		}
		return (int)(tiempo/contador);
	}
	
	private int getTiempoMayor(){
		Iterator<Long> itr = tiempos.iterator();
		long tiempo = 0;
		long tiempoMayor = 0;
		while(itr.hasNext())
		{
			tiempo = itr.next();
			if (tiempo>tiempoMayor)
			{
				tiempoMayor = tiempo;
			}
		}
		return (int)tiempoMayor;
	}
	
	private int getTiempoMenor(){
		Iterator<Long> itr = tiempos.iterator();
		long tiempo = 9999999;
		long tiempoMenor = 0;
		while(itr.hasNext())
		{
			tiempo = itr.next();
			if (tiempo<tiempoMenor)
			{
				tiempoMenor = tiempo;
			}
		}
		return (int)tiempoMenor;
	}
	
	public void empezarPartida()
	{//ESTO PRIMERO NO VA AL MOCK
	System.out.println("Para pasar palabra basta con pulsar enter, o escribir " +
			"'p', o 'pasapalabra'\n");
	System.out.println("Pulsa enter para comenzar una partida.\n");
	//A PARTIR DE AQUI TODO PASA POR LOS MOCKS
	try {
		scanner.nextLine(); // Lee del teclado cualquier cosa
		}
	catch (Exception e) 
	{
		muestraResultados.println("Error de teclado: "+e.getMessage());
	}
	muestraResultados.println("Comenzamos!!!");
	
	String textoTecleado;
	Pregunta laPregunta = null;
	long relojInterno;
	
	while (this.getLista().quedanPreguntas() && getTiempoRestante()>0)
	{
		laPregunta = this.getLista().sacarPregunta();
		{
		muestraResultados.println(laPregunta.getTexto());
		relojInterno = System.currentTimeMillis();
		textoTecleado = scanner.nextLine();
		tiempos.add(System.currentTimeMillis()-relojInterno);
		this.setTiempoRestante(this.getTiempoRestante() - (System.currentTimeMillis() - relojInterno));
		if (this.getTiempoRestante()<0)
		{
			break;
		}
		else if (textoTecleado.equals("p") || textoTecleado.equals("P") || textoTecleado.equals("") || textoTecleado.equals("pasapalabra"))
			{
				muestraResultados.println("Pasapalabra!!!");
				this.getLista().anadirPregunta(laPregunta);
			}
			else if(laPregunta.esCorrecta(textoTecleado))
			{
				muestraResultados.println("Correcto");
				this.sumarAcierto();
			}
				else
					{
						muestraResultados.println("No. La respuesta correcta era: "+laPregunta.getRespuesta()+"\n");
						this.sumarFallo();
						muestraResultados.println("Recuento: Aciertos= "+this.getAciertos()+" Fallos= "+this.getFallos());
							if (tiempoRestante>0)
								{
									muestraResultados.println("Te quedan "+this.getTiempoRestante()/1000+" segundos.");
									muestraResultados.println("\nPulsa enter para continuar.\n");
									try {
										scanner.nextLine(); // Lee del teclado cualquier cosa
										}
									catch (Exception e) 
									{
										muestraResultados.println("Error de teclado: "+e.getMessage());
									}
								}
							else
								{
									muestraResultados.println("Se te agot� el tiempo.!!!");
								}
					}	
			}
	}
	//Fin del Rosco por tiempo o falta de preguntas.
	//el recuento se podria haber metido recuento en un metodo
	muestraResultados.println("Puntuacion FINAL: Aciertos= "+this.getAciertos()+" Fallos= "+this.getFallos());
System.out.println("El tiempo medio de respuesta ha sido: "+(this.getMediaTiempos()/1000)+" segundos.");
System.out.println("La vez que mas has tardado ha sido: "+(this.getTiempoMayor()/1000)+" segundos.");
System.out.println("La vez que menos has tardado ha sido: "+(this.getTiempoMenor()/1000)+" segundos.");
	if (getTiempoRestante()>0)
	{
		muestraResultados.println("Te han sobrado: "+this.getTiempoRestante()/1000+" segundos.");
	}
	else
	{
		muestraResultados.println("Se te agot� el tiempo.!!!");
	}
	
}
	
}
