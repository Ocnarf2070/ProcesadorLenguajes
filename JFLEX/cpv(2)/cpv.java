import java.io.FileReader;
import java.io.IOException;
public class cpv{
	public static void main (String args[]){
		try{
			Yylex lex = null;
			if (args.length > 0) lex = new Yylex(new FileReader (args[0]));
			Yytoken yytoken=null;
			while((yytoken=lex.yylex())!=null);
			System.out.println("A "+lex.A);
			System.out.println("B "+lex.B);
			System.out.println("C "+lex.C);
			System.out.println("D "+lex.D);
		}catch (IOException e){
		}
	}
}
			
