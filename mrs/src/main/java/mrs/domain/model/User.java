package mrs.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "usr")
@Data
public class User implements Serializable {

	private static final long serialVersionUID = -8739935870568178798L;

	@Id
	private String userId;

	private String password;

	private String firstName;

	private String lastName;

	private Role roleName;
}
