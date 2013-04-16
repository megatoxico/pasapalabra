
public class Pregunta {

	String	texto;
	String	respuesta;
	char	letra;
	
	public Pregunta(char pLetra, String pTexto, String pRespuesta){
		this.respuesta = pRespuesta;
		this.texto = pTexto;
		this.letra = pLetra;
	}
	
	public boolean esCorrecta(String pRespuestaTecleada){
		//estaria bien filtrar acentos o simbolos...
		return (this.respuesta.equals(pRespuestaTecleada.toLowerCase()));
	}
	
	public String getRespuesta(){
		return this.respuesta;
	}
	
	private String getTexto(){
		return this.texto;
	}
	
	public char getLetra(){
		return this.letra;
	}
	
	public void imprimir(){
if (this.getLetra() == 'ñ' || this.getLetra() == 'q' || this.getLetra() == 'x' || this.getLetra() == 'y')
{
			System.out.println("Contiene la "+this.getLetra()+" :");
}
else
{
			System.out.println("Empieza con la "+this.letra+" :");
}
		System.out.println(this.getTexto());
	}
	
	
}
