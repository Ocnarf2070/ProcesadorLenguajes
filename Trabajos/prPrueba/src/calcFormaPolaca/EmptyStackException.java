package calcFormaPolaca;

@SuppressWarnings("serial")
public class EmptyStackException extends RuntimeException {
	public EmptyStackException () {
		super ();
	}
	public EmptyStackException (String msg) {
		super (msg);
	}
}
