import java.io.FileReader;
import java.io.IOException;
public class Main{
	public static void main (String args[]){
		try{	
			Yylex lex = null;
			if(args.length > 0)lex = new Yylex(new FileReader (args[0]));
			//else lex = new Yylex(System.in); 
			Yytoken yytoken = null;
			while((yytoken=lex.yylex())!=null);
			System.out.println();
		}catch (IOException e) {
		}
	}
}
