
import java.io.*;
import java.util.Scanner;

public class Rosco {

	private ListaPreguntas laLista;
	private int fallos, aciertos;
	private long tiempoRestante;
	
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
	
	public Rosco(ListaPreguntas pListaPreguntas){
		this.laLista = pListaPreguntas;
		this.aciertos = 0;
		this.fallos = 0;
		this.tiempoRestante = 90000;
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
	
	public void empezarPartida()
	{
	System.out.println("Comenzamos!!!");
	
	//Scanner sc = new Scanner(System.in);
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
		this.setTiempoRestante(this.getTiempoRestante() - (System.currentTimeMillis() - relojInterno));
		if (this.getTiempoRestante()<0)
		{
			break;
		}
		else if (textoTecleado.equals("p") || textoTecleado.equals("P") || textoTecleado.equals(""))
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
						muestraResultados.println("No. La respuesta correcta era: "+laPregunta.getRespuesta());
						this.sumarFallo();
						muestraResultados.println("Recuento: Aciertos= "+this.getAciertos()+" Fallos= "+this.getFallos());
							if (tiempoRestante>0)
								{
									muestraResultados.println("Te quedan "+this.getTiempoRestante()/1000+" segundos.");
									muestraResultados.println("\nPulsa una enter para continuar.\n");
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
									muestraResultados.println("Se te agotó el tiempo.!!!");
								}
					}	
			}
	}
	//Fin del Rosco por tiempo o falta de preguntas.
	//el recuento se podria haber metido recuento en un metodo
	muestraResultados.println("Puntuacion FINAL: Aciertos= "+this.getAciertos()+" Fallos= "+this.getFallos());
	if (getTiempoRestante()>0)
	{
		muestraResultados.println("Te han sobrado: "+this.getTiempoRestante()/1000+" segundos.");
	}
	else
	{
		muestraResultados.println("Se te agotó el tiempo.!!!");
	}
	
}
	
}
