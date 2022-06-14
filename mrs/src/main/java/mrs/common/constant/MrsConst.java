package mrs.common.constant;

public class MrsConst {

  public static final String QUERY_LAZY_MTG_ROOM =
      "SELECT DISTINCT x FROM ReservableRoom x LEFT JOIN FETCH x.meetingRoom WHERE x.reservableRoomId.reservedDate = :date ORDER BY x.reservableRoomId.roomId ASC";
}
