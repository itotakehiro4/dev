package docotsubu.common.exception;

public class DocotsubuBusinessException extends RuntimeException {

  private static final long serialVersionUID = -6172350999368227708L;

  public DocotsubuBusinessException() {
    super();
  }

  public DocotsubuBusinessException(String message) {
    super(message);
  }

  public DocotsubuBusinessException(String message, Throwable cause) {
    super(message, cause);
  }

  public DocotsubuBusinessException(Throwable cause) {
    super(cause);
  }

}
