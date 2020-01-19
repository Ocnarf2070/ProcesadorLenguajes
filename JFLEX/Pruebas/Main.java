import java.io.FileReader;
import java.io.IOException;
public class Main{
	public static void main (String args[]){
		try{	
			Yylex lex = new Yylex(new FileReader (args[0]));
			Yytoken yytoken = null;
			while((yytoken=lex.yylex())!=null);
			System.out.println();
		}catch (IOException e) {
		}
	}
}
