
public class EtiquetaDoble{
	private static int cont=0;
	private String f;
	private String v;
	public EtiquetaDoble(int num) {
		v=nuevaEtiqueta();
		if(num==2)f=nuevaEtiqueta();
	}
	private String nuevaEtiqueta() {
		return "L"+cont++;
	}
	public String f(boolean not) {
		if(!not)return f;
		else return v;
	}
	public String v(boolean not) {
		if(!not)return v;
		else return f;
	}
}
