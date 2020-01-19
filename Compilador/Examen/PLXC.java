import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.Reader;

public class PLXC{

	static public void main(String argv[]){
		try{
			Reader in = new InputStreamReader(System.in);
			if (argv.length>0) {
				in = new FileReader(argv[0]);
			}
			if(argv.length > 1){
				GenCod.out = new PrintStream(new FileOutputStream(argv[1]));
			}
			parser p = new parser(new Yylex(in));
			//p.debug_parse();
			p.parse();
			//System.out.println(result);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
