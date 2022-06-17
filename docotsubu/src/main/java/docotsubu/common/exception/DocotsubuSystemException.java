package docotsubu.common.exception;

public class DocotsubuSystemException extends SystemException {

  private static final long serialVersionUID = -501018227367743053L;

  public DocotsubuSystemException(String code, String message) {
    super(code, message);
  }

  public DocotsubuSystemException(String code, Throwable cause) {
    super(code, cause);
  }

  public DocotsubuSystemException(String code, String message, Throwable cause) {
    super(code, message, cause);
  }

}
