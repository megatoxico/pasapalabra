import java.util.ArrayList;

public class ListaPreguntas {
	 
	private ArrayList<Pregunta>	laLista;
	
	public ListaPreguntas(){
		laLista = new ArrayList<Pregunta>();
	}
	
	public void anadirPregunta(Pregunta pPregunta){
		this.getLista().add(pPregunta);
	}

	private ArrayList<Pregunta> getLista(){
		return this.laLista;
	}
	
	public Pregunta sacarPregunta(){
		Pregunta unaPregunta = this.getLista().get(0);
		this.getLista().remove(0);
		return unaPregunta;
		}
		
	public boolean quedanPreguntas(){
		return (this.getLista().size() > 0);
		}
	
}

