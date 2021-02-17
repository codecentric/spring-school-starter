package inc.monster.app.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data

@Entity
public class Axle {

	@Id
	@GeneratedValue
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	private Wheel left;
	@OneToOne(cascade = CascadeType.ALL)
	private Wheel right;
	@ManyToOne
	@ToString.Exclude
	private Car car;
}
