import java.util.HashMap;

public class carDB {

	private static HashMap<Integer, Car> carMap = new HashMap<>();

	//this actually makes no sense because cars can have the same id number
	//but have different use numbers and string to differentiate
	//but for the sake of having fun i just did it
	public static String generatePlate(carType t, boolean isRent, boolean isCarrier) {
		Car car = new Car(t, isRent, isCarrier);
		makeUnique(car);
		carMap.put(car.getIdNum(), car);
		return car.toString();
	}
	
	public static void makeUnique(Car car) {
		if(carMap.containsKey(car.getIdNum())) {
			car.overrideIdNum();
			makeUnique(car);
		} else {
			return;
		}
	}
	
	public static void main(String[] args) {
		String newCar = generatePlate(carType.PASSENGER, false, false);
		System.out.println(newCar);
	}
}
