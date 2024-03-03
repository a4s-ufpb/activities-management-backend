package apps4Society.infrastructure.repository.exception;

public class NaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NaoEncontradoException(String quantidade) {
		super(quantidade);
	}
}
