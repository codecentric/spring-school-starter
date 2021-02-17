package inc.monster.app.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Car {
	
	private Long id;
    private String name;
    private String brand;
    private Axle front;
    private Axle rear;
}
