import java.util.ArrayList;
import java.util.List;

public class Simbolo{
	private String value;
	private int level;
	private int type;
	private boolean isArray,isPointer;
	private int tam;
	
	public Simbolo(String value,int type, int level) {
		this.value=value;
		this.type=type;
		this.level=level;
		tam=0;
		isArray=false;
		isPointer=false;
		// TODO Auto-generated constructor stub
	}
	public String valor() {
		return value;
	}
	public int tipo(){
		return type;
	}

	public int nivel(){
		return level;
	}

	public boolean isPointer(){
		return isPointer;
	}

	public boolean isArray(){
		return isArray;
	}

	public int tam(){
		return tam;
	}

	public void setValor(String valor){
        if(valor == null){
            this.value = "0";
			//return;
        }

		/*if(GenCod.isIdent(valor) || GenCod.isTemp(valor)){
			valor = TablaSimbolo.UltSimb(valor).valor();
		}*/
		else{
			this.value = valor;
		}
	}

	public void setTipo(int tipo){
		this.type = tipo;
	}

	public void setNivel(int nivel){
		this.level = nivel;
	}

	public void setIsPointer(boolean flag){
		this.isPointer = flag;
	}

	public void setIsArray(boolean flag){
		this.isArray = flag;
	}

	public void setTam(int tam){
		this.tam = tam;
	}

	@Override
	public String toString(){
		return "(" + "valor: " + value + ", tipo: " + type + ", isArray: " + isArray + ")";
	}
}