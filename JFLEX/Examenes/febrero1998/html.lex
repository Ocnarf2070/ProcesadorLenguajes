import java.util.TreeMap;
import java.io.FileReader;
import java.io.IOException;
%%
%{
  static int total; 
  static int graficos;
  static int hipertextos;
  static int locales;
  static int externos;
  static int [] horarios = new int [24];
  static TreeMap <String,Integer> tabla = new TreeMap <String,Integer>();
  public static void main(String[] args)
	{
	try{
	Yylex lex = new Yylex(new FileReader (args[0]));
	Yytoken token = null;
	while ( (token=lex.yylex()) != null );
	}catch (IOException e) {
	}
	System.out.println("Accesos totales: "+total);
	System.out.println("Accesos a hipertextoss: "+hipertextos);
	System.out.println("Accesos a graficos: "+graficos);
	System.out.println("Accesos locales: "+locales);
	System.out.println("Accesos externos: "+externos);
	System.out.print("Accesos horarios:[");
	for (int i=0; i<24; i++)System.out.print(horarios[i]+" ");
	System.out.println("]");
	System.out.println("Accesos por paginas:");
	listartabla();
	}
  public static void listartabla(){
  	for(String k:tabla.keySet())System.out.println(k+"->"+tabla.get(k));
  }
  public void apuntar(String text){
  	if(!tabla.containsKey(text))tabla.put(text,1);
  	else tabla.put(text,tabla.get(text)+1);
  }

%}
%s PAGINA
%%
^[a-zA-Z0-9]+".lcc.uma.es"|
^"150.214.108."[0-9]+	{locales++;}
^[a-zA-Z0-9.]+		{externos++;}
[0-2][0-9]/:[0-9][0-9]:[0-9][0-9]\  {horarios[Integer.decode(yytext())]++;}
\"[A-Z]+	{yybegin(PAGINA);}
<PAGINA>[^\ \"]+.gif|
<PAGINA>[^\ \"]+.jpg	{graficos++;apuntar(yytext());}
<PAGINA>[^\ \"]+.html	{hipertextos++;apuntar(yytext());}
<PAGINA>[^\ \"]+\"	{yybegin(YYINITIAL);}
\n	{total++;}
.	{} /* ignorar el resto */

