import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class TablaSimbolo{

	private static Map<String, List<Simbolo>> tablaSimbolo = new HashMap<String, List<Simbolo>>();

	private static int index = 0;

	public static void addSimb(String lexema, Simbolo n){
		if(existe(lexema)){
			if(UltSimb(lexema).nivel() != index){
				tablaSimbolo.get(lexema).add(n);
			}
			else{
				GenCod.error();
			}
		}
		else{
			ArrayList<Simbolo> levels = new ArrayList<Simbolo>();
			levels.add(n);
			tablaSimbolo.put(lexema, levels);
		}
	}

	public static void nuevoBloque(){
		index++;
	}

//	public static String buscar(String lexema){
//		int n = tablaSimbolo.get(lexema).size();
//                if(n > 1){
//                        return lexema + "_" + tablaSimbolo.get(lexema).get(n-1).nivel();
//                }
//                else{
//                        return lexema;
//                }
//	}

	public static void finBloque(){
		if(index > 0)
			index--;
	}

	public static int indice(){
		return index;
	}

	public static void limpiar(Integer level){

		for(Iterator<Map.Entry<String, List<Simbolo>>> it = tablaSimbolo.entrySet().iterator(); it.hasNext(); ) {

			Map.Entry<String, List<Simbolo>> entry = it.next();
			List<Simbolo> levels = entry.getValue();
		      
		      	Simbolo ult = levels.get(levels.size()-1);
		      
		      	if(ult.nivel() == level) {
		        	entry.getValue().remove(levels.indexOf(ult));
		        
		        	if(entry.getValue().size() == 0)
		        		it.remove();
		      	}
		      
		}
	}

	public static boolean existe(String lexema){
		return tablaSimbolo.containsKey(lexema);
	}

	public static List<Simbolo> ListaSimb(String lexema){

		String salida = "";
		boolean flag = true;

		for(int i = 0; i < lexema.length() && flag; i++){
			if(lexema.charAt(i) == '_'){
				flag = false;
			}
			else{
				salida += lexema.charAt(i);
			}
		}
		return tablaSimbolo.get(salida);
	}

	public static Simbolo UltSimb(String lexema){
		return ListaSimb(lexema).get(ListaSimb(lexema).size()-1);
	}

	public static Map<String, List<Simbolo>> getSymbolTable(){
		return tablaSimbolo;
	}
}
