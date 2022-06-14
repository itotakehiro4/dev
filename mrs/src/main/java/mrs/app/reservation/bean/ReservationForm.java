package mrs.app.reservation.bean;

import java.io.Serializable;
import java.time.LocalTime;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;
import mrs.validator.EndTimeMustBeAfterStartTime;
import mrs.validator.ThirtyMinutesUnit;

@Data
@EndTimeMustBeAfterStartTime(message = "終了時刻は開始時刻より後にしてください")
public class ReservationForm implements Serializable {

  private static final long serialVersionUID = -4953320549163307784L;

  @NotNull(message = "必須です")
  @ThirtyMinutesUnit(message = "30分単位で入力してください")
  @DateTimeFormat(pattern = "HH:mm")
  private LocalTime startTime;

  @NotNull(message = "必須です")
  @ThirtyMinutesUnit(message = "30分単位で入力してください")
  @DateTimeFormat(pattern = "HH:mm")
  private LocalTime endTime;
}
