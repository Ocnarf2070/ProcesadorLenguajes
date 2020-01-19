package prueba;

public class k {
	public static void main(String[] args) {
		String l= "\\u0030";
		String k=l.substring(3);
		int i= Integer.decode("0x"+k);
		
		System.out.println(i);
	}
}
