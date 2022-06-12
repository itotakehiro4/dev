package mrs.domain.service.room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mrs.domain.model.MeetingRoom;
import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;
import mrs.domain.repository.room.ReservableRoomRepository;

@Service
@Transactional
public class RoomService {

//	@Autowired
//	ReservableRoomRepository reservableRoomRepository;

	public List<ReservableRoom> findReservableRooms(LocalDate date) {
		return createReservableRoomList();
	}

	private List<ReservableRoom> createReservableRoomList() {
		List<ReservableRoom> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ReservableRoom room = new ReservableRoom();
			MeetingRoom meet = new MeetingRoom();
			meet.setRoomId(i + 1);
			meet.setRoomName("会議室" + (i + 1));
			ReservableRoomId id = new ReservableRoomId();
			id.setRoomId(i + 1);
			id.setReservedDate(LocalDate.of(2022, i+1, i+1));
			room.setMeetingRoom(meet);
			room.setReservableRoomId(id);
			list.add(room);
		}
		return list;
	}
}
