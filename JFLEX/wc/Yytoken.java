public class Yytoken{
	public final static int LINEA = 127;
	public final static int PALABRA = 128;
	public final static int SEPARADOR = 129;
	private int token;
	private String valor;
	public Yytoken(int token,String valor){
		this.token = token;
		this.valor = valor;
	}
	public int getToken()  {
         	return token;
    	}
	public String getValor(){
		return valor;
	}
}
