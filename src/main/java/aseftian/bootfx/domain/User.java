package aseftian.bootfx.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author ASeftian
 *
 */

@Entity
@Table(name = "t_users")
@Data
@NoArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = 7506380219398290337L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length = 36)
	private String uuid;
	@Column(length = 50)
	private String username;
	@Column(name = "first_name", length = 50)
	private String firstName;
	@Column(name = "last_name", length = 50, nullable = true)
	private String lastName;
	private LocalDate dob;
	@Column(length = 1)
	private String gender;
	@Column(length = 10)
	private String role;
	@Column(length = 50)
	private String email;
	@Column(length = 50)
	private String password;

}
