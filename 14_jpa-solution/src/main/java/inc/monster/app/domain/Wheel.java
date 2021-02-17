package inc.monster.app.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
public class Wheel {
	
	private Long id;
	private String brand;
	@ToString.Exclude
	private Axle axle;
}
