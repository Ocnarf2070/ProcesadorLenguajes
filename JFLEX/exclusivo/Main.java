import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String arg[]) {
      try{
        Yylex lex = new Yylex(new FileReader(arg[0]));
        Yytoken yytoken = null;
        while((yytoken = lex.yylex()) != null);
      }catch(IOException e){
      }
    }
}
