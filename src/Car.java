import java.util.Random;
/**
 * the facts are from:
 * ko.wikipedia.org/wiki/%EB%8C%80%ED%95%9C%EB%AF%BC%EA%B5%AD%EC%9D%98_%EC%B0%A8%EB%9F%89_%EB%B2%88%ED%98%B8%ED%8C%90
 * @author sonsooji
 */
public class Car {
	
	/**
	 * possible useStr values
	 * values at index
	 * 0~4 are given to passenger cars,
	 * 5~13 are given to MPVs,
	 * 14~22 are given to trucks,
	 * 23~31 are given to specialty cars,
	 * 32~33 are given to rent-a-cars,
	 * 34 is given to carrier cars
	 */
	public static final String[] strID = {"가", "나", "다", "라", "마",
			"거", "너", "더", "러", "머", "버", "서", "어", "저",
			"고", "노", "도", "로", "모", "보", "소", "오", "조",
			"구", "누", "두", "루", "무", "부", "수", "우", "주",
			"하", "호", "배"};
	
	private carType type; 	// 차종 
	private int useNum;	  	// 용도기호 
	private String useStr;	// 용도기호 한글 
	private int idNum;		// 뒷 자리 숫자 
	
	/**
	 * constructor for a car license plate
	 * The license number of Korean cars follow the specified format:
	 * 		use number use string  id number
	 * For instance, 75너 8885 is a valid Korean car license number
	 * The use number is specified as follows:
	 * 		passenger cars: 01~69
	 * 		MPV			  : 70~79
	 * 		Trucks		  : 80~97
	 * 		Specialty cars: 98~99
	 * The use string is specified as follows:
	 * 		passenger cars: 가~마
	 * 		MPV			  : 거~저
	 * 		Trucks		  : 고~조
	 * 		Specialty cars: 구~주
	 * The id number is any 4 digit number ranging from 0000 to 9999
	 * @param t an enum that specifies the car type
	 * @param isRent a boolean that specifies whether the car is rented or not
	 * @param isCarrier a boolean that specifies whether the car is a carrier car or not
	 */
	public Car(carType t, boolean isRent, boolean isCarrier) {
		Random rand = new Random();
		type = t;
		switch (type) {
		case PASSENGER:
			useNum = rand.nextInt(70)+1; //1~69 are given to passenger cars
			useStr = strID[rand.nextInt(5)]; //index 0~4
			break;
		case MPV:
			useNum = rand.nextInt(10)+70; //70~79
			useStr = strID[rand.nextInt(9)+5]; //index 5~13
			break;
		case TRUCK:
			useNum = rand.nextInt(18)+80; //80~97
			useStr = strID[rand.nextInt(9)+14]; //index 14~22
			break;
		case SPECIALTY:
			useNum = rand.nextInt(2)+98; //98~99
			useStr = strID[rand.nextInt(9)+23]; //index 23~31
			break;
		}
		if(isCarrier) {
			useStr = strID[34]; //index 34
		}
		//rented cars should override all existing assignment,
		//for the first thing that should identify them is the fact that they're rented
		if(isRent) {
			useStr = strID[rand.nextInt(2)+32]; //index 32~33
		}
		idNum = rand.nextInt(9999);
	}
	
	public String getType() { return type.toString(); }
	public int getUseNum() { return useNum; }
	public String getUseStr() { return useStr; }
	public int getIdNum() { return idNum; }
	
	public int overrideIdNum() {
		Random rand = new Random();
		this.idNum = rand.nextInt(9999);
		return idNum;
	}
	
	/**
	 * returns the string-ified form of the license plate
	 */
	public String toString() {
		return useNum + useStr + " " + idNum;
	}
}
