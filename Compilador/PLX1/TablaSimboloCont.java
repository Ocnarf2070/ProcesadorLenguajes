import java.util.HashMap;

public class TablaSimboloCont{
	HashMap<String, Integer> hm;
	public TablaSimboloCont() {
		hm=new HashMap<String, Integer>();
		// TODO Auto-generated constructor stub
	}
	public void addOrUpdate(String lexema,boolean up) {
		int rep=search(lexema);
		hm.put(lexema, up?rep+1:rep-1);
	}
	public int search(String lexema) {
		int k=hm.get(lexema)==null?0:hm.get(lexema);
		return k;
	}
}