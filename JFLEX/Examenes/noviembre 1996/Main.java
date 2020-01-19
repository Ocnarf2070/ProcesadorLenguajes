import java.io.FileReader;
import java.io.IOException;
public class Main{
	public static void main (String args[]){
		try{	
			Yylex lex = null;
			if(args.length > 0)lex = new Yylex(new FileReader (args[0]));
			//else lex = new Yylex(System.in); 
			Yytoken yytoken = null;
			while((yytoken=lex.yylex())!=null){
				System.out.print(yytoken.toString()+" ");
				String num = yytoken.getValor();
				int type = yytoken.getToken();
				if(type == Yytoken.TOKEN_CTE_ENTERO || type == Yytoken.TOKEN_CTE_ENTERO_LARGO)
					if(num.charAt(num.length()-1)=='l' || num.charAt(num.length()-1)=='L'){
						num = num.substring(0,num.length()-1);
						long num2 = Long.valueOf(Integer.decode(num));
						System.out.println(num2);
					}else System.out.println(Integer.decode(num));
				else System.out.println(Float.parseFloat(num));
			};
		}catch (IOException e) {
		}
	}
}
