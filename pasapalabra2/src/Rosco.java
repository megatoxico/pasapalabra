
import java.io.IOException;
import java.util.Scanner;

public class Rosco {

	private ListaPreguntas laLista;
	private int fallos, aciertos;
	private long tiempoRestante;
	
	
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

	private int getAciertos(){
		return this.aciertos;
	}
	
	private int getFallos(){
		return this.fallos;
	}
	
	private long getTiempoRestante(){
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
	Scanner sc = new Scanner(System.in);
	String textoTecleado;
	Pregunta laPregunta = null;
	long relojInterno;
	
	while (this.getLista().quedanPreguntas() && getTiempoRestante()>0)
	{
		laPregunta = this.getLista().sacarPregunta();
		{
		laPregunta.imprimirTexto();
		relojInterno = System.currentTimeMillis();
		textoTecleado = sc.next();
		this.setTiempoRestante(this.getTiempoRestante() - (System.currentTimeMillis() - relojInterno));
		if (this.getTiempoRestante()<0)
		{
			break;
		}
		else if (textoTecleado.equals("p") || textoTecleado.equals("P"))
			{
				System.out.println("Pasapalabra!!!");
				this.getLista().anadirPregunta(laPregunta);
			}
			else if(laPregunta.esCorrecta(textoTecleado))
			{
				System.out.println("Correcto");
				this.sumarAcierto();
			}
				else
					{
						System.out.println("No. La respuesta correcta era: "+laPregunta.getRespuesta());
						this.sumarFallo();
						System.out.println("Recuento: Aciertos= "+this.getAciertos()+" Fallos= "+this.getFallos());
							if (tiempoRestante>0)
								{
									System.out.println("Te quedan "+this.getTiempoRestante()/1000+" segundos.");
									System.out.println("\nPulsa una tecla para continuar.\n");
									try {
										System.in.read(); // Lee del teclado
										}
									catch (IOException e) 
									{
										System.out.println("Error de teclado: "+e.getMessage());
									}
								}
							else
								{
									System.out.println("Se te agot� el tiempo.!!!");
								}
					}	
			}
	}
	//Fin del Rosco por tiempo o falta de preguntas.
	//el recuento se podria haber metido recuento en un metodo
	System.out.println("Puntuacion FINAL: Aciertos= "+this.getAciertos()+" Fallos= "+this.getFallos());
	if (getTiempoRestante()>0)
	{
		System.out.println("Te han sobrado: "+this.getTiempoRestante()/1000+" segundos.");
	}
	else
	{
		System.out.println("Se te agot� el tiempo.!!!");
	}
	
}
	
}
