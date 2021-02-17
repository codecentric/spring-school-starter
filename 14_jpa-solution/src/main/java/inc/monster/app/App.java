package inc.monster.app;

import inc.monster.app.domain.Axle;
import inc.monster.app.domain.Car;
import inc.monster.app.domain.Wheel;
import inc.monster.app.service.CarRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        Car car = makeDefaultCar();

        CarRepository cars = context.getBean(CarRepository.class);

        System.out.println(cars.count());
        car = cars.save(car);
        System.out.println(cars.count());
    }

    private static Car makeDefaultCar() {
    	return makeCar("Awesome Car", "Volvo", "Michelin");
    }

	private static Car makeCar(String name, String carBrand, String wheelBrand) {
		Car car = new Car();
		Axle front = new Axle();
		Axle rear = new Axle();

		Wheel leftFront = new Wheel();
        leftFront.setBrand(wheelBrand);
        leftFront.setAxle(front);

        Wheel rightFront = new Wheel();
        rightFront.setBrand(wheelBrand);
        rightFront.setAxle(front);

        front.setLeft(leftFront);
        front.setRight(rightFront);
        front.setCar(car);

        Wheel leftRear = new Wheel();
        leftRear.setBrand(wheelBrand);
        leftRear.setAxle(rear);

        Wheel rightRear = new Wheel();
        rightRear.setBrand(wheelBrand);
        rightRear.setAxle(rear);

        rear.setLeft(leftRear);
        rear.setRight(rightRear);
        rear.setCar(car);

        car.setRear(rear);
        car.setFront(front);
        car.setName(name);
        car.setBrand(carBrand);

        return car;
	}
}
