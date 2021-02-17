package inc.monster.app.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Car {

	@Id
	@GeneratedValue
	private Long id;
    private String name;
    private String brand;
    @OneToOne(cascade = CascadeType.ALL)
    private Axle front;
    @OneToOne(cascade = CascadeType.ALL)
    private Axle rear;
}
