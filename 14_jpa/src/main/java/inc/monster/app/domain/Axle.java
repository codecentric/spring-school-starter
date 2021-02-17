package inc.monster.app.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class Axle {
	
	private Long id;
	private Wheel left;
	private Wheel right;
	@ToString.Exclude
	private Car car;
}
