import java.io.FileReader;
import java.io.IOException;
public class main {
public static void main (String arg[]){

if (arg.length>0) {
	try {
	Yylex lex = new Yylex(new FileReader(arg[0]));
	Yytoken yytoken = null;
	while (  (yytoken = lex.yylex()) != null  );
	}catch (IOException e) {
	}
}
}
}