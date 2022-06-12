package mrs.domain.model;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Reservation implements Serializable {

	private static final long serialVersionUID = -6557775226647678958L;

	private Integer reservationId;

	private LocalTime startTime;
	
	private LocalTime endTime;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name = "reserved_date"), @JoinColumn(name = "room_id")})
	private ReservableRoom reservableRoom;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
