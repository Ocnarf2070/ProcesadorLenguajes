package calc;


public class CalculadoraNumerica {
	
	public double sumar(double a, double b){
		return a+b;
	}
	
	public double restar(double a, double b){
		return a-b;
	}
	
	public double multiplicar(double a, double b){
		return a*b;
	}
	
	
	
	public double dividir(double a, double b)throws DenominadorEsCeroExceptions{
		
		if(b == 0){
			throw new DenominadorEsCeroExceptions("el divisor no puede ser cero");
		
		
		}else{
			
			return a/b;
		}
				
	}

}