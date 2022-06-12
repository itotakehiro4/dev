package mrs.app.room;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import mrs.domain.model.ReservableRoom;
import mrs.domain.service.room.RoomService;

/**
 * 予約可能会議室一蘭表示コントローラ
 * 
 * @author t_ito
 *
 */
@Controller
@RequestMapping("rooms")
public class RoomsController {

  @Autowired
  private RoomService roomService;

  @GetMapping(path = "{date}")
  public String listRooms(
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date,
      Model model) {
    List<ReservableRoom> rooms = roomService.findReservableRooms(date);
    model.addAttribute("date", date);
    model.addAttribute("rooms", rooms);
    return "room/listRooms";
  }

  @GetMapping
  public String listRooms(Model model) {
    LocalDate today = LocalDate.now();
    model.addAttribute("date", today);
    return listRooms(today, model);
  }
}
