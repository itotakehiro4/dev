package mrs.domain.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Reservation implements Serializable {

	private static final long serialVersionUID = -6557775226647678958L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reservationId;

	private LocalTime startTime;
	
	private LocalTime endTime;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name = "reserved_date"), @JoinColumn(name = "room_id")})
	private ReservableRoom reservableRoom;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	/**
	 * 予約時間帯重複チェック
	 * @param target 対象予約情報
	 * @return チェック結果
	 */
	public boolean overlap(Reservation target) {
		// 2つの予約の日付・部屋が別であれば重複していないため、falseを返却
		if (!Objects.equals(reservableRoom.getReservableRoomId(), target.reservableRoom.getReservableRoomId())) {
			return false;
		}
		
		// 2つの予約の開始時刻と終了時刻が一致する場合は重複のため、trueを返却
		if (startTime.equals(target.getStartTime()) && endTime.equals(target.endTime)) {
			return true;
		}
		
		// 2つの予約の開始時刻と終了時刻が交差しているか、または包含関係であるかを返却
		return target.endTime.isAfter(startTime) && endTime.isAfter(target.startTime);
	}
}
