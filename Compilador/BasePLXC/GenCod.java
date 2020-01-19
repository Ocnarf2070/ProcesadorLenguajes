import java.io.PrintStream;
import java.util.regex.Pattern;

public class GenCod{

	protected static PrintStream out = System.out;
	private static int contTemp = 0;
	private static int contLabel = 0;

	public static String genTemp(){
		String temp = "$t" + contTemp++;
		return temp;
	}

	public static String getLabel(){
		return "L" + contLabel++;
	}

	public static void print(String exp){
		out.println("print " + exp + ";");
	}

	public static void error(){
		out.println("error;\nhalt;");
	}

	public static void goTo(String label){
		out.println("goto " + label + ";");
	}

	public static void label(String label){
		out.println("label "+label+";");
	}

	public static void asig(String var, String exp) {
			out.println(var+" = "+exp+";");
	}

	public static void arrayAsig(String var, String exp, String index){
			
	}
	public static String Double (String e,String op, boolean before) {
		if(before) {
			out.println(e+" = "+e+" "+op+" 1;");
			return e;
		}
		else {
			String temp = genTemp();
			asig(temp, e);
			out.println(e+" = "+e+" "+op+" 1;");
			return temp;
		}
		
	}

	public static String mas(String e1, String e2){
		String temp = genTemp();
		out.println(temp+" = "+e1+" + "+e2);
		return temp;
		
	}

    public static String menos(String e1, String e2){
    	String temp = genTemp();
		out.println(temp+" = "+e1+" - "+e2);
		return temp;
	}

    public static String por(String e1, String e2){
    	String temp = genTemp();
		out.println(temp+" = "+e1+" * "+e2);
		return temp;
	}

    public static String div(String e1, String e2){
    	String temp = genTemp();
		out.println(temp+" = "+e1+" / "+e2);
		return temp;
	}

    public static String mod(String e1, String e2){
        String temp="",temp2="";
        //if(tipo==Tipo.DOUBLE||tipo2==Tipo.DOUBLE)error();
       // else {
        	 temp=div(e1, e2);
        	 temp2=por(temp,e2);
        	 temp=menos(e1,temp2);
       // }
        return temp;
    }
    
    public static EtiquetaDoble condicion(String arg1, int cond, String arg2){
		String tagV = getLabel();
		String tagF = getLabel();

		switch(cond){
			case If.GT:
				out.println("if (" + arg2 + " < " + arg1 + ") goto " + tagV + ";");
				out.println("goto " + tagF + ";");
				break;
			case If.LT:
				out.println("if (" + arg1 + " < " + arg2 + ") goto " + tagV + ";");
				out.println("goto " + tagF + ";");
				break;
			case If.EQ:
				out.println("if (" + arg1 + " == " + arg2 + ") goto " + tagV + ";");
				out.println("goto " + tagF + ";");
				break;
			case If.LTE:
				out.println("if (" + arg2 + " < " + arg1 + ") goto " + tagF + ";");
				out.println("goto " + tagV + ";");
				break;
			case If.GTE:
				out.println("if (" + arg1 + " < " + arg2 + ") goto " + tagF + ";");
				out.println("goto " + tagV + ";");
				break;
			case If.NEQ:
				out.println("if (" + arg1 + " == " + arg2 + ") goto " + tagF + ";");
				out.println("goto " + tagV + ";");
				break;
		}

		return new EtiquetaDoble(tagV, tagF);
	}
    
	/*public static void dimension(String ident, String index){
		if(isArray(ident) && isArray(index)){
			boolean flag = true;
			String aux = "";
			for(int i = 0; i < ident.length() && flag; i++){
				if(ident.charAt(i) == '['){
					flag = false;
				}
				else{
					aux += ident.charAt(i);
				}
			}
			ident = aux;

			aux = "";
			flag = true;

			for(int j = 0; j < index.length() && flag; j++){
				if(index.charAt(j) == '['){
					aux += index.charAt(j+1) + "";
					flag = false;
				}
			}

			index = aux;
		}

		if(isTemp(ident)){
			return;
		}

		if(!TablaSimbolo.UltSimb(ident).isArray()){
			return;
		}

		EtiquetaDoble tag = new EtiquetaDoble(getLabel(), getLabel());
		int size = TablaSimbolo.UltSimb(ident).tam();

		out.println("# Comprobacion de rango");
		out.println("if (" + index + " < 0) goto " + tag.v() + ";");
		out.println("if (" + size + " < " + index + ") goto " + tag.v() + ";");
		out.println("if (" + size + " == " + index + ") goto " + tag.v() + ";");
		goTo(tag.f());
		label(tag.v());
		error();
		label(tag.f());
	}*/

   

	/*public static String cast(String exp, int tipo){
		String temp = genTemp(tipo);

		asig(temp, exp);
		
		return temp;
	}*/

	

	/*public static boolean isReal(String in){
		Pattern p = Pattern.compile("[-]?[0-9]*\\.[0-9]+[eE]*[+-]?[0-9]*");

		return Pattern.matches(p.pattern(), in);
	}

	public static boolean isInteger(String in){
		Pattern p = Pattern.compile("0|[1-9][0-9]*");

		return Pattern.matches(p.pattern(), in);
	}

	public static boolean isIdent(String in){
		Pattern p = Pattern.compile("[_a-zA-Z][_a-zA-Z0-9]*");

		return Pattern.matches(p.pattern(), in);
	}

	public static boolean isTemp(String in){
		Pattern p = Pattern.compile("[$][a-zA-Z][_a-zA-Z0-9]*");

		return Pattern.matches(p.pattern(), in);
	}

	public static boolean isArray(String in){
		Pattern p = Pattern.compile("[_a-zA-Z]+(?:\\[[_a-zA-Z0-9]*\\])+");

		return Pattern.matches(p.pattern(), in);
	}

	public static boolean isZero(String in){
		Pattern p = Pattern.compile("[0]*\\.?[0]*");

		return Pattern.matches(p.pattern(), in);
	}

	private static int check(String raw){
		if(isInteger(raw)){
			return Tipo.INT;
		}
		if(isReal(raw)){
			return Tipo.DOUBLE;
		}
		if(isIdent(raw)){
			return TablaSimbolo.UltSimb(raw).tipo();
		}
		if(isTemp(raw)){
			return TablaSimbolo.UltSimb(raw).tipo();
		}
		return -1;
	}*/
}
