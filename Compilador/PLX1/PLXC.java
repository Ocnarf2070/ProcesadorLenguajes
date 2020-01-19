import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.InputStreamReader;

import java.io.Reader;
public class PLXC {	
	public static void gc(String op, String exp1, String exp2, String aux){
		if(op.equals("PRINT"))	out.println("print "+exp1+";");
		else if(op.equals("ASIG"))	out.println(aux+" = "+exp1+";");
		else if(op.equals("MAS")) out.println(aux+" = "+exp1+" + "+exp2+";");
		else if(op.equals("MENOS")) out.println(aux+" = "+exp1+" - "+exp2+";");
		else if(op.equals("POR")) out.println(aux+" = "+exp1+" * "+exp2+";");
		else if(op.equals("DIV")) out.println(aux+" = "+exp1+" / "+exp2+";");
		else if(op.equals("GOTO")) out.println("goto "+aux+";");
		else if(op.equals("LABEL")) out.println("label "+aux+";");
		else if(op.substring(0, 2).equals("IF")) {
			String modo=op.substring(2);
			if(modo.equals("LT")) {
				out.println("if ("+exp1+" < "+exp2+") goto "+aux+";");
			}else if(modo.equals("EQ")) {
				out.println("if ("+exp1+" == "+exp2+") goto "+aux+";");
			}
		}else if(op.equals("ERROR"))out.println("error;");
	}
	public static PrintStream out; 
	
	public static void main(String argv[]) throws IOException {    
		try {
			Reader in = new InputStreamReader(System.in);	
			if (argv.length>0) {
				out = new PrintStream(System.out);
				in = new FileReader(argv[0]);
			}
			if (argv.length>1) {
				out = new PrintStream(new File(argv[1]));
			}
			parser p = new parser(new Yylex(in));
			//p.debug_parse();
			p.parse();
			out.close();
			//System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}
}