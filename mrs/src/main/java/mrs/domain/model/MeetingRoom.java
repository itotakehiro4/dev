package mrs.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class MeetingRoom implements Serializable {

  private static final long serialVersionUID = 7613003953437476906L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer roomId;

  private String roomName;
}
