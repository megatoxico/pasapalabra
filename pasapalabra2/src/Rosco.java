
import java.io.IOException;
import java.util.Scanner;


public class Rosco {

	private ListaPreguntas laLista;
	private int fallos, aciertos;
	private long relojInterno, tiempo;
	private Pregunta laPregunta;
	
	
	
	public Rosco(ListaPreguntas pListaPreguntas){
		this.laLista = pListaPreguntas;
		this.aciertos = 0;
		this.fallos = 0;
		this.tiempo = 90000;
	}

	public void sumarAcierto(){
		this.aciertos++;
	}
	
	public void sumarFallo(){
		this.fallos++;
	}

	public int getAciertos(){
		return this.aciertos;
	}
	
	public int getFallos(){
		return this.fallos;
	}
	
	public long getTiempo(){
		return this.tiempo;
	}

	public Pregunta getLaPregunta()
	{
		return laPregunta;
	}
	private void iniciarRelojInterno(){
		relojInterno = System.currentTimeMillis();
	}
	
	private long pararRelojInterno(){
		return System.currentTimeMillis() - relojInterno;
	}
	
	public boolean haAcertado(String pTextoTecleado){
		return getLaPregunta().esCorrecta(pTextoTecleado);
	}
	
	private ListaPreguntas getLista(){
		return this.laLista;
	}
	
	public boolean quedanPreguntas(){
		return this.getLista().quedanPreguntas();
	}
	
	public void sacarPregunta(){
		laPregunta= this.getLista().sacarPregunta();	
	}
	
	public void pasarPregunta(){
		this.getLista().anadirPregunta(laPregunta);
	}
	
	public void setTiempo(long pTiempo)
	{
		this.tiempo = pTiempo;
	}
	
	public void empezarPartida(){
	System.out.println("Comenzamos!!!");
	Scanner sc = new Scanner(System.in);
	String textoTecleado;
	
	while (quedanPreguntas() && getTiempo()>0){
		sacarPregunta();
		{
		getLaPregunta().imprimir();
		this.iniciarRelojInterno();
		textoTecleado = sc.next();
		this.setTiempo(this.getTiempo() - this.pararRelojInterno());
		if (this.getTiempo()<0)
			break;
		if (textoTecleado.equals("p"))
		{
			System.out.println("Pasapalabra!!!");
			this.pasarPregunta();
		}
		else if(haAcertado(textoTecleado))
		{
			System.out.println("Correcto");
			this.sumarAcierto();
		}
			else
		{
			System.out.println("Nooooooo. La respuesta correcta era: "+getLaPregunta().getRespuesta());
			this.sumarFallo();
			System.out.println("Recuento: Aciertos= "+this.getAciertos()+" Fallos= "+this.getFallos());
			if (tiempo>0)
			{
			System.out.println("Te quedan "+this.getTiempo()/1000+" segundos.");
			System.out.println("\nPulsa una tecla para continuar.\n");
			try {
				System.in.read(); // Lee del teclado
				} catch (IOException e) {
				}
			}
			else
			{
				System.out.println("Se te agotó el tiempo.!!!");
			}
			}
	}
	
	}
	//se podria haber metido recuento en un metodo, pero creemos que al ser solo una linea no merece la pena
	System.out.println("Puntuacion FINAL: Aciertos= "+this.getAciertos()+" Fallos= "+this.getFallos());
	if (getTiempo()>0)
	{
	System.out.println("Te han sobradop "+this.getTiempo()/1000+" segundos.");
	}
	else
	{
		System.out.println("Se te agotó el tiempo.!!!");
	}
	}
	
}
