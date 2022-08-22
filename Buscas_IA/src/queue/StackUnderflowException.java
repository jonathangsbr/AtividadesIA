package queue;

public class StackUnderflowException extends Exception {

	private static final long serialVersionUID = 1L;

	public StackUnderflowException() {
		super("Stack Underflow Exception - nao e possível acessar um elemento de uma fila vazia");
	}
}