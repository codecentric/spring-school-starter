package inc.monster.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@Entity
public class Wheel {

	@Id
	@GeneratedValue
	private Long id;
	private String brand;
	@ManyToOne
	@ToString.Exclude
	private Axle axle;
}
