import java.util.*;
public class TablaDeSimbolos{
	private static HashMap <String, Simbolo> t[];
	private static final int MAX =10;
	private static int index=0;
	public TablaDeSimbolos(){
		t = new HashMap[MAX];
	}
	public Simbolo add(String nombre,Tipo tipo){
		Simbolo s = new Simbolo(nombre, tipo);
		t[index].put(nombre, s);
		return s;
	}
	public Simbolo search(String nombre){
		for(int i=index;i>=0;i--) {
			Simbolo s = (t[index].get(nombre));
			if(s!=null)return s;
		}
		return null;
	}
	public void print(){
		for(int i=0;i<index;i++) {
			Iterator<Simbolo> it = t[i].values().iterator();
			while(it.hasNext()){
				Simbolo s = (Simbolo)it.next();
				System.out.println(s.lexema() + ": "+ s.tipo());
			}
		}
	}
	protected Set<String> lexemas() {
		return t[index].keySet();
	}
	public static void NuevoBloque() {
		index++;
	}
	public static void FinBloque() {
		t[index].clear();
		index--;
	}

}
