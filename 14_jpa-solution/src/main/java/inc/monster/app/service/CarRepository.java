package inc.monster.app.service;

import inc.monster.app.domain.Car;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepository extends PagingAndSortingRepository<Car, Long> {

	List<Car> findByBrand(String brand);

	@Query("select c from Car c where c.front.left.brand = :brand or c.front.right.brand = :brand or c.rear.left.brand = :brand or c.rear.right.brand = :brand")
	List<Car> findByWheelBrand(String brand);
}
