import java.util.*;
public class TablaDeSimbolos{
	private HashMap <String, Simbolo> t[];
	private static final int MAX =10;
	private static int index=0;
	public TablaDeSimbolos(){
		t = new HashMap[MAX];
		for(int i=0;i<MAX;i++)t[i]=new HashMap<String, Simbolo>();
	}
	public void add(String nombre,Tipo tipo){
		Simbolo s = new Simbolo(nombre, tipo);
		t[index].put(nombre, s);
	}
	public Simbolo search(String nombre){
		for(int i=index;i>=0;i--) {
			HashMap<String, Simbolo> hm = t[i];
			Simbolo s = hm.get(nombre);
			if(s!=null)return s;
		}
		return null;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<index;i++) {
			Iterator<Simbolo> it = t[i].values().iterator();
			while(it.hasNext()){
				Simbolo s = (Simbolo)it.next();
				sb.append(s.lexema() + ": "+ s.tipo()+"\n");
			}
		}
		return sb.toString();
	}
	protected Set<String> lexemas() {
		return t[index].keySet();
	}
	public void NuevoBloque() {
		index++;
	}
	public void FinBloque() {
		t[index].clear();
		index--;
	}
	public static int getIndex() {
		return index;
	}

}
