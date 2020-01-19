import java.io.FileReader;
import java.io.IOException;
public class wc {
public static void main (String arg[]){

if (arg.length>0) {
	try {
	int caracteres = 0,palabras = 0,lineas = 0;
	Yylex lex = new Yylex(new FileReader(arg[0]));
	Yytoken yytoken = null;
	while (  (yytoken = lex.yylex()) != null  ) {
		if(yytoken.getToken() == Yytoken.PALABRA){
			System.out.println(yytoken.getValor());
			caracteres += yytoken.getValor().length();
			palabras++;
		} else if (yytoken.getToken() == Yytoken.LINEA){
			caracteres++;
			lineas++;
		} else caracteres++;		
	}
	System.out.println(lineas+"\t"+palabras+"\t"+caracteres+" "+arg[0].toString());
	}catch (IOException e) {
	}
}
}
}
