package mrs.exception;

public class UnavailableReservationException extends RuntimeException {

  private static final long serialVersionUID = -4159411800602262786L;

  public UnavailableReservationException(String message) {
    super(message);
  }
}
