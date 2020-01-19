

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cambios {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String label = "",aux="";
		Scanner sc = new Scanner(new File(args[0]));
		PrintWriter pw = new PrintWriter("prog_.ctd");
		while(sc.hasNextLine()){
			String line =sc.nextLine();
			Scanner ss = new Scanner(line);
			String str = ss.next();
			if(str.equals("label")) {
				if(!ss.next().equals(label)) {
					pw.write(aux);
					pw.write(line+"\n");
				}
				aux="";
			}
			else if(str.equals("goto")) {
				aux="";
				label = ss.next();
				aux+=line+"\n";
			}else {
				if(sc.hasNextLine())pw.write(line+"\n");
				else pw.write(line);
			}
		}
		pw.close();
	}

}
