import java.io.FileReader;

import java.io.FileOutputStream;

import java.io.PrintStream;

import java.io.InputStreamReader;

import java.io.PrintWriter;

import java.io.Reader;



public class PLC {	   

	public static PrintStream out; 

	public static void main(String argv[]) {    

    try {

      Reader in = new InputStreamReader(System.in);	

      if (argv.length>0) {

    	  out = new PrintStream(new FileOutputStream("prog.ctd"));

    	  in = new FileReader(argv[0]);

      }

      if (argv.length>1) {

    	  out = new PrintStream(new FileOutputStream(argv[1]));

      }

      parser p = new parser(new Yylex(in));

      //p.debug_parse();

      Object result =  p.parse().value;

      out.print(result);

      out.close();

      //System.out.println(result);

    } catch (Exception e) {

      e.printStackTrace();

    }

  }

}