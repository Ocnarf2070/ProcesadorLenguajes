package calc;


public class Calculadora {
	
	private Cola<String> signos = new Cola<String>();

	private Cola<String> numeros = new Cola<String>();

/**
 *post: evalua la expresion y devuelve el resultado 
 */
	public double evaluar(String[] expresion) {

		double resultado=0.0;

		/*Clasifica la expresión en signos o numeros*/
		this.clasificarSigno(expresion);

		/*Si la expresion tiene más de un elemento*/
		if(expresion.length>1){	


			/*El resultado actual toma el valor del primer número*/
			double resultadoActual = new Double(numeros.frente());

			/*Mientras que haya signos*/
			while(!signos.vacia()){


				/* Si el primer signo que está al frente de la cola es un paréntesis  realiza
				 *lo que está dentro, comenzando con sacar el primer signo de la cola*/
				if(signos.frente().equals("(")){

					this.implementacionParentesis(resultadoActual);					

					}
					/*  Si no se cumple la condición, se guarda el número que está al frente de la 
					 * Cola"numeros"(se lo transformó de String a double) en una variable llamada numeroA,
					 * luego lo desacola y si la Cola"numeros" no está vacia hace lo mismo con el próximo 
					 * número que está al frente guardandolo en una variable llamada numeroB y realiza la 
					 * cuenta correspondiente y desacola de la Cola"signos" el signo utilizado. El resultado
					 * de la cuenta se guarda en la variable resultadoActual.
					 *  Luego acola el resultadoActual en la Cola"numeros", transformandolo previamente de un
					 *  double a un String*/
					else{

						double numeroA= new Double(numeros.frente());
						numeros.desacolar();

						if(!numeros.vacia()){
						double numeroB= new Double(numeros.frente());
						numeros.desacolar();
						resultadoActual=hacerCuenta(numeroA,numeroB,signos.frente());
						signos.desacolar();
						}


						String resultadoActualString2= String.valueOf(resultadoActual);
						numeros.acolar(resultadoActualString2);

					}

				}
				/*  Pasa el número que está al frente de la Cola"numeros" de String a double
				 * a una variable llamada resultado*/
				resultado=new Double(numeros.frente());

				}//fin de implementación para expresiones con más de un elemento

		/*  Si la expresión tiene un solo elemento se transforma el número que está al frente
		 * de la Cola"numeros" de String a double y se lo guarda en la variable resultado*/
		else{ 
			//inicio de implementación para expresiones con un solo elemento
			resultado= new Double(numeros.frente());

		}//fin de implementación para expresiones con un solo elemento

		return resultado;
	}	
			/**
			 * El valor del parámetro segundoNumero en el caso de la resta y división va 
			 * a ser al que reste y divida respectivamente. En la suma y multiplicación 
			 * el orden no altera al resultado
			 * 
			 * @param primerNumero es el primer número que se ingresa(double)
			 * @param segundoNumero es el segundo número que se ingresa(double)
			 * @param signo es el operador que se va a utilizar en la cuenta(String)
			 * @return devuelve el resultado de la cuenta
			 * 
			 */
	private double hacerCuenta(double primerNumero, double segundoNumero, String signo1){

		/*transforma el String en un char para que lo analice el switch*/
		char signo = signo1.charAt(0);
		double resultado=0.0;
		CalculadoraNumerica unaCalculadora = new CalculadoraNumerica();
		switch(signo){

			case'+':
				resultado = unaCalculadora.sumar(primerNumero, segundoNumero);
				break;

			case'-': 
				resultado = unaCalculadora.restar(primerNumero,segundoNumero);
				break;

			case'*':
				resultado = unaCalculadora.multiplicar(primerNumero,segundoNumero);
				break;

			case '/':
				resultado = unaCalculadora.dividir(primerNumero,segundoNumero);

		}

		return resultado;
		}


	/**
	 * post:evalua la expresion y clasifica entre simbolos y numeros
	 */
	private void clasificarSigno(String[] expresion){
		for (int i=0; i<expresion.length; i++){

			if("+".equals(expresion[i])||"-".equals(expresion[i])||"*".equals(expresion[i])
				||"/".equals(expresion[i])||"(".equals(expresion[i])||")".equals(expresion[i])){

				signos.acolar(expresion[i]);

				}else{
					numeros.acolar(expresion[i]);
				}
			}

		}

	private void implementacionParentesis(double resultadoActual){
		//inicio implementeción "Parentesis"
					signos.desacolar();

					/*  Busca el paréntesis de cierre, mientras no lo encuentre va a realizar 
					 * distintos pasos explicados luego*/
					while(!(signos.frente().equals(")"))){

						/* Si el signo que está al frente de la Cola"signos" es un paréntesis de apertura
						* lo desacola y agrega un paréntesis de apertura a la Cola"signos"*/
						if(signos.frente().equals("(")){
							signos.desacolar();
							signos.acolar("(");
						}
						/* Transforma el String en un valor double y se lo guarda en una variable,
						 *luego se retira el número de la Cola"numeros" */
						double numeroUno= new Double(numeros.frente());
						numeros.desacolar();




						/*  Si la cola"numeros" no está vacia se guarda el signo que esta al frente
						 * (perteneciente a la Cola "signos"), luego se desacola al signo*/
						if(!(numeros.vacia())&&!(signos.vacia())){
							String signoRevisado= signos.frente();
							signos.desacolar();

							/*  Si se cumple la condición anterior y el signo al frente de la Cola"signos"
							 * es un paréntesis de apertura acola un paréntesis de apertura y también
							 * a la variable signoRevisado. Si no se cumple que el signo que está
							 * al frente es un paréntesis de apertura, se guarda el número que está al frente
							 * de la Cola"numeros", luego lo desacola y realiza la cuenta correspondiente
							 * para asignarle un nuevo valor a la variable resultadoActual*/
							if(signos.frente().equals("(")){
								signos.acolar("(");
								signos.acolar(signoRevisado);

							}else{

								double numeroDos= new Double(numeros.frente());
								numeros.desacolar();	
								resultadoActual=hacerCuenta(numeroUno,numeroDos,signoRevisado);
								/*transforma el valor de la variable de un double a un String y la acola
								 * en la Cola"numeros"*/
								String numero= String.valueOf(resultadoActual);
								numeros.acolar(numero);
								}				
							}


						}//fin de la búsqueda de paréntesis de cierre

						/*  Si el signo que está al frente es un paréntesis de cierre lo desacola
						 * de la Cola"signos"*/
						if(signos.frente().equals(")")){
							signos.desacolar();

							/*  Si se cumple la condición anterior y la Cola"signos" no está vacia
							 * se guarda dentro de una variable llamada signoAUsar el signo que
							 * está al frente, luego lo desacola, y se acola en la Cola"signos" 
							 * la variable signoAUsar*/
							if(!signos.vacia()){
								String signoAUsar=signos.frente();
									signos.desacolar();
									signos.acolar(signoAUsar);
								}
						}


						//fin de la implementación "Paréntesis"

	}
}