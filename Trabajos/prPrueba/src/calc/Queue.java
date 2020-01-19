package calc;

public interface Queue<T> {
	void acolar(T elem);
	void desacolar();
	T frente();
	boolean vacia();
}

