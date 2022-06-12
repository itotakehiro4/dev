package mrs.app.reservation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;
import mrs.domain.model.Reservation;
import mrs.domain.model.Role;
import mrs.domain.model.User;
import mrs.domain.service.reservation.AlreadyReservedException;
import mrs.domain.service.reservation.ReservationService;
import mrs.domain.service.reservation.UnavailableReservationException;
import mrs.domain.service.room.RoomService;

@Controller
@RequestMapping("reservations/{date}/{roomId}")
public class ReservationsController {

  @Autowired
  private RoomService roomService;

  @Autowired
  private ReservationService reservationService;

  @ModelAttribute
  public ReservationForm setUpForm() {
    ReservationForm form = new ReservationForm();
    // デフォルト値
    form.setStartTime(LocalTime.of(9, 0));
    form.setEndTime(LocalTime.of(10, 0));
    return form;
  }

  /**
   * 会議室予約画面一覧表示
   * 
   * @param date
   * @param roomId
   * @param model
   * @return
   */
  @GetMapping
  public String reserveForm(
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date,
      @PathVariable("roomId") Integer roomId, Model model) {
    ReservableRoomId reservableRoomId = new ReservableRoomId(roomId, date);

    List<Reservation> reservations = reservationService.findReservations(reservableRoomId);

    List<LocalTime> timeList = Stream.iterate(LocalTime.of(0, 0), t -> t.plusMinutes(30))
        .limit(24 * 2).collect(Collectors.toList());

    model.addAttribute("room", roomService.findMeetingRoom(roomId));
    model.addAttribute("reservations", reservations);
    model.addAttribute("timeList", timeList);
    model.addAttribute("user", dummyUser());
    return "reservation/reserveForm";

  }

  /**
   * 予約
   * @param formData
   * @param bindingResult
   * @param date
   * @param roomId
   * @param model
   * @return
   */
  @PostMapping
  public String reserve(@Validated ReservationForm formData, BindingResult bindingResult,
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date,
      @PathVariable("roomId") Integer roomId, Model model) {
    
    if (bindingResult.hasErrors()) {
      return reserveForm(date, roomId, model);
    }
    
    ReservableRoom reservableRoom = new ReservableRoom(new ReservableRoomId(roomId, date));
    Reservation reservation = new Reservation();
    reservation.setStartTime(formData.getStartTime());
    reservation.setEndTime(formData.getEndTime());
    reservation.setReservableRoom(reservableRoom);
    reservation.setUser(dummyUser());
    
    try {
      reservationService.reserve(reservation);
    } catch (UnavailableReservationException | AlreadyReservedException e) {
      model.addAttribute("error", e.getMessage());
      return reserveForm(date, roomId, model);
    }
    return "redirect:/reservations/{date}/{roomId}";
  }

  /**
   * キャンセル
   * @param reservationId
   * @param roomId
   * @param date
   * @param model
   * @return
   */
  @PostMapping(params = "cancel")
  public String cancel(@RequestParam("reservationId") Integer reservationId, @PathVariable("roomId") Integer roomId, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date, Model model) {
    
    User user = dummyUser();
    try {
      reservationService.cancel(reservationId, user);
    } catch (IllegalStateException e) {
      model.addAttribute("error", e.getMessage());
      return reserveForm(date, roomId, model);
    }
    return "redirect:/reservations/{date}/{roomId}";
  }
  
  /**
   * ダミーユーザ
   * 
   * @return
   */
  private User dummyUser() {
    User user = new User();
    user.setUserId("taro-yamada");
    user.setFirstName("太郎");
    user.setLastName("山田");
    user.setRoleName(Role.USER);
    return user;
  }
}
