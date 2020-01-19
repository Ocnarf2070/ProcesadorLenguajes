public class Yytoken  {
  public final static int TOKEN_A = 1;
  public final static int TOKEN_B = 2;
  public final static int TOKEN_C = 3;
  public final static int TOKEN_D = 4;

  private int token;
  private String lexema;

  public Yytoken(int token, String lexema){
    this.token = token;
    this.lexema = lexema;
  }
  public int getToken(){
    return token;
  }

  public String getLexema(){
    return lexema;
  }

  public String toString(){
    return "<" + token + "," + lexema + ">";
  }
}
