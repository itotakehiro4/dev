package mrs.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class ReservableRoomId implements Serializable {

	private static final long serialVersionUID = 1992666431015096742L;

	private Integer roomId;

	private LocalDate reservedDate;
	
}
