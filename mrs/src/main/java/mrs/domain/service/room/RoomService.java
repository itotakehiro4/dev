package mrs.domain.service.room;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mrs.domain.model.MeetingRoom;
import mrs.domain.model.ReservableRoom;
import mrs.domain.repository.room.MeetingRoomRepository;
import mrs.domain.repository.room.ReservableRoomRepository;

@Service
@Transactional
public class RoomService {

	@Autowired
	private MeetingRoomRepository meetingRoomRepository;
	
	@Autowired
	private ReservableRoomRepository reservableRoomRepository;

	/**
	 * 会議室取得
	 * @param roomId 部屋ID
	 * @return 会議室情報
	 */
	public MeetingRoom findMeetingRoom(Integer roomId) {
		return meetingRoomRepository.findById(roomId).get();
	}
	
	/**
	 * 予約情報一覧取得
	 * @param date 予約日付
	 * @return 予約情報一覧
	 */
	public List<ReservableRoom> findReservableRooms(LocalDate date) {
		return reservableRoomRepository.findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(date);
	}
}
