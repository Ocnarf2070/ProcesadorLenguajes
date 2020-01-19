package calc;

import org.junit.Assert;
import org.junit.Test;



public class CalculadoraTEST {
	
	private Calculadora miCalculadora = new Calculadora();
	@Test
	public void p1() {
	}
	
	@Test
	public void evaluarUno(){
		String[] expresion = { "1" };

		double resultado = miCalculadora.evaluar(expresion);
		Assert.assertEquals(1.0, resultado, 0.0001);
	}
	@Test
	public void sumarUnoMasUno(){

		String[] expresion = {"1", "+", "1","*","2"};
		double resultado = miCalculadora.evaluar(expresion);
		Assert.assertEquals( 3.0,resultado, 0.0001 );
	}
	@Test
	public void dividirPorMenosUno(){

		String[] expresion = {"1", "/", "-1"};
		double resultado = miCalculadora.evaluar(expresion);
		Assert.assertEquals( -1.0,resultado, 0.0001 );


	}
	@Test
	public void dividirPorMenosUnoEnParentesis(){

		String[] expresion = {"1", "/", "(","-1",")"};
		double resultado = miCalculadora.evaluar(expresion);
		Assert.assertEquals( -1.0,resultado, 0.0001 );

	}

	@Test
	public void multiplicarPorMenosUno(){

		String[] expresion = {"1", "*", "-1"};
		double resultado = miCalculadora.evaluar(expresion);
		Assert.assertEquals( -1.0,resultado, 0.0001 );


	}
	@Test
	public void multiplicarPorMenosUnoEnParentesis(){

		String[] expresion = {"1", "*", "(","-1",")"};
		double resultado = miCalculadora.evaluar(expresion);
		Assert.assertEquals( -1.0,resultado, 0.0001 );

	}


	@Test
	public void multiplicarParentesisPorMenosUno(){

		String[] expresion = {"(","1", "+","1", ")", "*", "(","-1",")"};
		double resultado = miCalculadora.evaluar(expresion);
		Assert.assertEquals( -2.0,resultado, 0.0001 );

	}

	@Test
	public void evaluarTresMenosUno(){

		String[] expresion = {"3", "-" ,"1" };
		Assert.assertEquals(2.0, this.miCalculadora.evaluar(expresion), 0.0001);
	}
	@Test
	public void evaluarConParentesis(){

		String[] expresion = {"(", "1", ")"};
		Assert.assertEquals(1.0, this.miCalculadora.evaluar(expresion), 0.0001);

	}
	@Test
	public void evaluarSumaConParentesis(){

		String[] expresion = {"(", "1","+", "1", ")"};
		Assert.assertEquals(2.0, this.miCalculadora.evaluar(expresion), 0.0001);

	}
	@Test
	public void evaluarSumasConParentesisMasUno(){
		String[] expresion = {"(", "1","+", "1", ")", "+", "1"};
		Assert.assertEquals(3.0, this.miCalculadora.evaluar(expresion), 0.0001);

	}
	@Test
	public void evaluarSumaConParentesisYMultiplicacion(){
		String[] expresion = new String[] {"(","(", "1" , "+", "3",")", "*", "(", "4", "+","5", ")", ")"};
		Assert.assertEquals(36.0 , this.miCalculadora.evaluar(expresion), 0.0001);

	}

	@Test
	public void evaluarMultiplicacionConParentisis(){

		String[] expresion = {"(","1","*","2",")"};

		Assert.assertEquals(2.0, this.miCalculadora.evaluar(expresion),0.000000001);
	}

	@Test
	public void evaluarDivisionConParentisis(){

		String[] expresion = {"(","6","/","2",")"};

		Assert.assertEquals(3.0, this.miCalculadora.evaluar(expresion),0.000000001);
	}

	@Test
	public void evaluarSumaConCuatroParentisis(){

		String[] expresion = {"(","6","+","2",")","+","(","1","+","1",")"};

		Assert.assertEquals(10.0, this.miCalculadora.evaluar(expresion),0.000000001);
	}

	@Test
	public void evaluarMultiplicacionConCuatroParentisis(){

		String[] expresion = {"(","6","+","2",")","*","(","1","+","1",")"};

		Assert.assertEquals(16.0, this.miCalculadora.evaluar(expresion),0.000000001);
	}

	@Test
	public void evaluarDivisionConCuatroParentisis(){

		String[] expresion = {"(","6","+","2",")","/","(","1","+","1",")"};

		Assert.assertEquals(4.0, this.miCalculadora.evaluar(expresion),0.000000001);
	}

	@Test
	public void multiplicacionConSeisParentesis(){
	String[] expresion = {"(","(", "1", "+", "5", ")","*","(", "8", "-", "6", ")", ")"};

	Assert.assertEquals(12.0, this.miCalculadora.evaluar(expresion),0.000000001);
	}

	@Test
	public void sumaEntreCincoNumeros(){
		String[] expresion = {"6","+","2","+","1","+","1","+","30"};
		Assert.assertEquals(40.0, this.miCalculadora.evaluar(expresion),0.000000001);
	}

	@Test
	public void multiplicacionConOchoParentesis(){


		String[] expresion = {"(","6","+","2",")","*","(","1","+","1",")","*","(","3","*","2",")","*","(","1","+","1",")"};

		Assert.assertEquals(192.0, this.miCalculadora.evaluar(expresion),0.000000001);
	}

	@Test
	public void sumaEntreCincoNumerosDentroDeParentesis(){
		String[] expresion = {"(","6","+","2","+","1","+","1","+","30",")"};
		Assert.assertEquals(40.0, this.miCalculadora.evaluar(expresion),0.000000001);
	}

	@Test
	public void multiplicacionConSeisParentesisB(){

		String[] expresion = {"(","6","+","2",")","*","(","1","+","1",")","*","(","3","*","2",")"};

		Assert.assertEquals(96.0, this.miCalculadora.evaluar(expresion),0.000000001);
	}

	@Test
	public void multiplicacionConDiezParentesis(){


		String[] expresion = {"(","(","6","+","2",")","*","(","1","+","1",")","*","(","3","*","2",")","*","(","1","+","1",")",")"};

		Assert.assertEquals(192.0, this.miCalculadora.evaluar(expresion),0.000000001);

	}
	@Test
	public void divisionConSeisParentesis(){
		String[] expresion = {"(","(", "1", "+", "5", ")","/","(", "8", "-", "6", ")", ")"};

		Assert.assertEquals(3.0, this.miCalculadora.evaluar(expresion),0.000000001);
	}

	@Test
	public void divisionConOchoParentesis(){


	String[] expresion = {"(","6","+","2",")","/","(","1","+","1",")","/","(","1","*","2",")","/","(","7","/","7",")"};

	Assert.assertEquals(2.0, this.miCalculadora.evaluar(expresion),0.000000001);
	}

	@Test
	public void evalularExpresionDelEjercicio(){
		String[] expresion = {"(","(", "15", "+", "59", ")", "*", "(", "85", "-", "26", ")",")" };
		Assert.assertEquals(4366.0, this.miCalculadora.evaluar(expresion),0.000000001);
	}
	
	@Test (expected = DenominadorEsCeroExceptions.class)
	public void evaluarDvisionPorCero(){
		String[] expresion = {"(", "5", "/", "0", ")" };
		this.miCalculadora.evaluar(expresion);
		
	}

}