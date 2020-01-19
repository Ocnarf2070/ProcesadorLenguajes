package prCalculadora;

import java.io.File;
import java.io.*;
import java.util.*;
import java.util.Stack;

public class Calculadora {

	public static String [] operacion (String line) {
		String line1 = line;
		String [] op = new String [line.length()+1];
		int tam = 0;
		String num ="";
		while(line1.length()!=0) {
			if(tam==op.length)op=Arrays.copyOf(op, tam*2);
			char elem = line1.charAt(0);
			if (Character.isDigit(elem))num+=elem;
			else if(signoValido(elem)) {
				if(tam!=0 && elem=='-'&& op[tam-1].equals("-")&&!Character.isDigit(line1.charAt(1))) {
					op[tam-1]=null;
					op[tam-2]=null;
					tam-=2;
				}
				else if(elem == '-' &&Character.isDigit(line1.charAt(1))&&num=="") num+='-';
				else if (elem == '(') {
					op[tam]="(";
					tam++;
				}
				else {
					if(tam!=0&&op[tam-1].equals(")")) {
						op[tam] = Character.toString(elem);
						tam++;
					}
					else if(elem == '-') {
						if(num!=""&&num!="-") {
							op[tam] = num;
							num="-";
							op[tam+1] = "+";
							
						}
						else {
							op[tam] = "0";
							op[tam+1] = "-";
						}
						tam+=2;

					}
					else {
						op[tam] = num;
						num ="";
						op[tam+1] = Character.toString(elem);
						tam+=2;
					}
				}
			} else throw new NoSuchElementException();
			line1 = line1.substring(1);
		}
		if(num!="")op[tam] = num;
		tam+=2;
		return op;
	}
	
	private static boolean signoValido(char elem) {
		// TODO Auto-generated method stub
		return elem == '+' || elem == '-' || elem == '*'|| elem == '/' || elem == '(' || elem == ')';
	}
	private static Object resultado(String [] fp) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		while(fp[i]!=null) {
			if(fp[i].equals("+")) {
				int exp2 = stack.pop();
				int exp1 = stack.pop();
				stack.push(exp1+exp2);
			}else if(fp[i].equals("-")) {
				int exp2 = stack.pop();
				int exp1 = stack.pop();
				stack.push(exp1-exp2);
			}else if(fp[i].equals("*")) {
				int exp2 = stack.pop();
				int exp1 = stack.pop();
				stack.push(exp1*exp2);
			}else if(fp[i].equals("/")) {
				int exp2 = stack.pop();
				int exp1 = stack.pop();
				if(exp2 == 0)throw new IllegalArgumentException("el denominador no debe ser 0");
				else stack.push(exp1/exp2);
			}else stack.push(Integer.parseInt(fp[i]));
			i++;
		}
		return stack.isEmpty()?" ":stack.pop();
	}
	
	private static void printList(String [] list) {
		System.out.print("[");
		int i = 0;
		while(list[i]!=null) {
			if(list[i+1]==null) System.out.print(list[i]);
			else System.out.print(list[i]+",");
			i++;
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryExpressionTree bt;
		if(args.length==2) {
			File in = new File(args[0]);
			File out = new File(args[1]);
			try {
				Scanner sc = new Scanner (in);
				PrintWriter pw = new PrintWriter(out);
				while(sc.hasNextLine()) {
					bt = new BinaryExpressionTree();
					String line = sc.nextLine().replaceAll("\\s","");
					String [] op = operacion (line);
					printList(op);
					String [] fp = bt.formaPolaca(op);
					pw.println(resultado(fp));
				}
				pw.close();
				sc.close();
				
			}catch(NoSuchElementException e){
				System.err.println("No tiene elementos validos");
				e.printStackTrace();
			}catch(IllegalArgumentException ee) {
				System.err.println("Linea de calculo mal formada");
				ee.printStackTrace();
			}catch(FileNotFoundException ee) {
				System.err.println("Archivo no encontrado");
			}
			
		}else if (args.length==0) {
			try {
				System.out.println("Introduzca la operacion:");
				Scanner sc = new Scanner (System.in);
				bt = new BinaryExpressionTree();
				String line = sc.nextLine().replaceAll("\\s","");
				sc.close();
				String [] op = operacion (line);
				printList(op);
				String [] fp = bt.formaPolaca(op);
				printList(fp);
				System.out.print(resultado(fp));
				
			}catch(NoSuchElementException e){
				System.err.println("No tiene elementos validos");
				e.printStackTrace();
			}catch(IllegalArgumentException ee) {
				System.err.println("Linea de calculo mal formada");
				ee.printStackTrace();
			}
			
		}
		
	}

}