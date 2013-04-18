
public class Pregunta {

	String	texto;
	String	respuesta;
	char	letra;
	
	public Pregunta(char pLetra, String pTexto, String pRespuesta){
		this.respuesta = filtrar(pRespuesta);
		this.texto = pTexto;
		this.letra = pLetra;
	}
	private String filtrar(String pTexto)
	{
		String tuString = pTexto.toLowerCase();
		tuString = tuString.replace ('á','a');
		tuString = tuString.replace ('é','e');
		tuString = tuString.replace ('í','i');
		tuString = tuString.replace ('ó','o');
		tuString = tuString.replace ('ú','u');
		return tuString;
	}
	
	public boolean esCorrecta(String pRespuestaTecleada){
		String respuestaTecleada = filtrar(pRespuestaTecleada);
		return (this.respuesta.equals(respuestaTecleada));
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
			System.out.println("Empieza con la "+this.getLetra()+" :");
}
		System.out.println(this.getTexto());
	}
	
	
}
