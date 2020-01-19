import java.io.FileReader;
import java.io.IOException;

public class cpv{
  private static int A = 0;
  private static int B = 0;
  private static int C = 0;
  private static int D = 0;

  public static void main(String args[]){
    try{
      if (args.length > 0){
        Yylex lex = new Yylex(new FileReader(args[0]));
        Yytoken yytoken = null;
        while((yytoken = lex.yylex()) != null){
          System.out.println(yytoken.toString());
          if(yytoken.getToken() == Yytoken.TOKEN_A) A++;
          if(yytoken.getToken() == Yytoken.TOKEN_B) B++;
          if(yytoken.getToken() == Yytoken.TOKEN_C) C++;
          if(yytoken.getToken() == Yytoken.TOKEN_D) D++;
        }
        System.out.println("A "+ A);
        System.out.println("B "+ B);
        System.out.println("C "+ C);
        System.out.println("D "+ D);
      }
    }catch (IOException e){
      System.out.println("Error al abrir el fichero de entrada.");
    }
  }
}
