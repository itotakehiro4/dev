package mrs.domain.service.reservation;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;
import mrs.domain.model.Reservation;
import mrs.domain.model.Role;
import mrs.domain.model.User;
import mrs.domain.repository.reservation.ReservationRepository;
import mrs.domain.repository.room.ReservableRoomRepository;

@Service
@Transactional
public class ReservationService {

  @Autowired
  private ReservationRepository reservationRepository;

  @Autowired
  private ReservableRoomRepository reservableRoomRepository;

  public void cancel(Integer reservationId, User requestUser) {
    Reservation reservation = reservationRepository.findById(reservationId).get();
    if (Role.ADMIN != requestUser.getRoleName()
        && !Objects.equals(reservation.getUser().getUserId(), requestUser.getUserId())) {
      throw new IllegalStateException("要求されたキャンセルは許可できません。");
    }
    reservationRepository.delete(reservation);
  }

  /**
   * 予約
   * 
   * @param reservation 予約情報
   * @return 予約情報
   */
  public Reservation reserve(Reservation reservation) {
    ReservableRoomId reservableRoomId = reservation.getReservableRoom().getReservableRoomId();

    // 対象の部屋が予約可能かどうかチェック
    ReservableRoom reservable = reservableRoomRepository.findById(reservableRoomId).get();
    if (reservable == null) {
      // 例外をスローする。
      throw new UnavailableReservationException("入力の日付・部屋の組み合わせは予約できません。");
    }

    // 重複チェック
    boolean overlap = reservationRepository
        .findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId).stream()
        .anyMatch(x -> x.overlap(reservation));

    if (overlap) {
      // 例外をスローする
      throw new AlreadyReservedException("入力の時間帯はすでに予約済です。");
    }

    // 予約情報の登録
    reservationRepository.save(reservation);
    return reservation;
  }

  public List<Reservation> findReservations(ReservableRoomId reservableRoomId) {
    return reservationRepository
        .findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId);
  }
}
