import java.util.Random;
import java.io.*;

public class AlmacenPreguntas {

private static AlmacenPreguntas miAlmacen = new AlmacenPreguntas();
private int[] cuantasPreguntas;
private String nombreFicheroFuente;

private AlmacenPreguntas() {
}

public static AlmacenPreguntas getMiAlmacen(){
	return miAlmacen;
}

public Rosco dameUnRosco(){
	return dameUnRosco("preguntas.dat");
}

public Rosco dameUnRosco(String pNombreFicheroFuente){
	setNombreFicheroFuente(pNombreFicheroFuente);
	if(cuantasPreguntas==null)
	{
	cuantasPreguntas= new int[26];
	contarPreguntas();
	}
	ListaPreguntas laLista = hacerUnRosco();
	Rosco miRosco = new Rosco(laLista);
	return miRosco;
}

public void contarPreguntas(){
	String line;
	int indiceLetra = 0;
	int contador = 0;
	try{
		FileReader fr = new FileReader(getNombreFicheroFuente());
		BufferedReader br = new BufferedReader(fr);
		br.readLine(); //nos saltamos la primera linea que es *a
		
		//contamos el numero de preguntas de cada letra

		while ((line=br.readLine()) != null) {     
	if (line.charAt(0) != '*'){
		contador++;
	}
	else
	{
		setCuantasPreguntas(indiceLetra,contador);
		contador = 0;
		indiceLetra++;
	}
	}  
	}

	catch(IOException e){
		System.out.println("Error con el fichero: "+e.getMessage());
	}
	}

private void setCuantasPreguntas(int pIndice, int pCuantas)
{
	cuantasPreguntas[pIndice] = pCuantas;
}

private int getCuantasPreguntas(int pIndice)
{
	return cuantasPreguntas[pIndice];
}

private void setNombreFicheroFuente(String pNombreFicheroFuente)
{
	nombreFicheroFuente = pNombreFicheroFuente;
}

private String getNombreFicheroFuente()
{
	return nombreFicheroFuente;
}

	private ListaPreguntas hacerUnRosco()
	{
		ListaPreguntas laLista = new ListaPreguntas();
		Pregunta unaPregunta;
		String line;
		String letras = "abcdefghijklmnñopqrstuvxyz";
		
		try{
			FileReader fr = new FileReader(getNombreFicheroFuente());
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			int seleccionada;
			int posAsterisco;
			
			while ((line=br.readLine()) != null) 
			{
				for (int j=0;j<26;j++)
				{
					seleccionada = aleatorio(getCuantasPreguntas(j));
				
					for(int i=0;i<seleccionada;i+=1)
					{
						line=br.readLine();
					}
					
					//creamos un objeto pregunta y lo añadimos a la lista de preguntas.
					posAsterisco = line.indexOf("*");
					unaPregunta = new Pregunta(letras.charAt(j),line.substring(0, posAsterisco),line.substring(posAsterisco+1));
					laLista.anadirPregunta(unaPregunta);
					//avanzamos hasta siguiente asterisco
					while (br.readLine().charAt(0) !='*')
					{
					}
					//pasamos a la siguiente letra
				}
			}
			br.close();   
		}
		catch(IOException e)
		{
			System.out.println("Error con el fichero: "+e.getMessage());
		}
	return laLista;
}

private int aleatorio(int pMax){
	Random aleatorio = new Random();
	int numero = aleatorio.nextInt(pMax) + 1;
	return numero;
}

}	
