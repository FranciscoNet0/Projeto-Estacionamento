
public class ClienteNullException extends Exception {
	public ClienteNullException() {
		super("Foi passado um valor null no lugar de um cliente");
	}
}
