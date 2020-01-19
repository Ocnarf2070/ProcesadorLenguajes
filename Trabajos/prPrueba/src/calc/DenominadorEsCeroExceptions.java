package calc;



@SuppressWarnings("serial")
public class DenominadorEsCeroExceptions extends RuntimeException {

	public DenominadorEsCeroExceptions(String mensaje) {
		super(mensaje);
		System.out.println("el denominador no puede ser cero");
	}
	
 
}