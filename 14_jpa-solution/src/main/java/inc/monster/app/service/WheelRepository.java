package inc.monster.app.service;

import inc.monster.app.domain.Wheel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface WheelRepository extends PagingAndSortingRepository<Wheel, Long> {
}
