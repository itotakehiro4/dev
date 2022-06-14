package mrs.exception;

public class AlreadyReservedException extends RuntimeException {

  private static final long serialVersionUID = 7458724358664493713L;

  public AlreadyReservedException(String message) {
    super(message);
  }
}
