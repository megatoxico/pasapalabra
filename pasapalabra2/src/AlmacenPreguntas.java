import java.util.Random;
import java.io.*;

public class AlmacenPreguntas {

private static AlmacenPreguntas miAlmacen = new AlmacenPreguntas();
private static Random aleatorio = new Random();
private static int[] cuantasPreguntas = new  int[26];
private static String letras = "abcdefghijklmnñopqrstuvxyz";
private static boolean datosCargados = false;

private AlmacenPreguntas() {
}

public static AlmacenPreguntas getMiAlmacen(){
	return miAlmacen;
}

public static Rosco dameUnRosco(){
	if(!getDatosCargados())
	{
	cargarPreguntas();
	}
	ListaPreguntas laLista = hacerUnRosco();
	Rosco miRosco = new Rosco(laLista);
	return miRosco;
}

public static void cargarPreguntas(){
	String line;
	int indice = 0;
	int contador = 0;
	try{
		FileReader fr = new FileReader("preguntas.dat");
		BufferedReader br = new BufferedReader(fr);
		br.readLine();
		//br.mark(10000);
		//contamos el numero de preguntas de cada letra
	while ((line=br.readLine()) != null) {     
	if (line.charAt(0) == '*'){
		setCuantasPreguntas(indice,contador);
		// System.out.println("Letra: "+indice+" lineas: "+contador);
		contador = 0;
		indice++;
	}
	else
	{
		contador++;
		//System.out.println(line);  
	}
	}  
	setDatosCargados(true);
	}

	catch(IOException e){
		System.out.println("Error con el fichero: "+e.getMessage());
	}
	}

private static void setCuantasPreguntas(int pIndice, int pCuantas)
{
	cuantasPreguntas[pIndice] = pCuantas;
}

private static int getCuantasPreguntas(int pIndice)
{
	return cuantasPreguntas[pIndice];
}

private static void setDatosCargados(boolean pEstado)
{
	datosCargados = pEstado;
}

private static boolean getDatosCargados()
{
	return datosCargados;
}

	private static ListaPreguntas hacerUnRosco()
	{
		ListaPreguntas laLista = new ListaPreguntas();
		Pregunta unaPregunta;
		String line;
		int indice = 0;
		try{
			FileReader fr = new FileReader("preguntas.dat");
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			indice=0;
			int seleccionada;
			
			//ATENCION CAMBIAR A ACCESO RANDOM ES IMPORTANTE!!!
			
			while ((line=br.readLine()) != null) {
				seleccionada = aleatorio(getCuantasPreguntas(indice));
				for(int i=1;i<seleccionada;i+=1)
					{
					br.readLine();
					}
		//creamos un objeto pregunta y lo añadimos a la lista de preguntas.
		int posAsterisco = line.indexOf("*");
		unaPregunta = new Pregunta(letras.charAt(indice),line.substring(0, posAsterisco),line.substring(posAsterisco+1));
		laLista.anadirPregunta(unaPregunta);
		//avanzamos hasta siguiente asterisco
		while (br.readLine().charAt(0) !='*'){
		}
		//pasamos a la siguiente letra
		indice++;
	}

	br.close();   
	}
	catch(IOException e){
		System.out.println("Error con el fichero: "+e.getMessage());
	}
return laLista;
}


private static int aleatorio(int pMax){
	return aleatorio.nextInt(pMax)+1;
}

}	


