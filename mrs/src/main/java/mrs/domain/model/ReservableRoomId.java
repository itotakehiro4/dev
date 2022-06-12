package mrs.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservableRoomId implements Serializable {

  private static final long serialVersionUID = 1992666431015096742L;

  private Integer roomId;

  private LocalDate reservedDate;

}
