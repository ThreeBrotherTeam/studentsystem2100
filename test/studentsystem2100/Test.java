package studentsystem2100;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++)
			System.out.println(createRandomDate());
	}

	private static String createRandomDate() {
		Random r = new Random();
		// yyyy-MM-dd
		String year = (int) (Math.random() * (2018 - 1990) + 1990) + "";
		String mouth = (int) (Math.random() * (12 - 1) + 1) + "";
		if (mouth.length() == 1) {
			mouth = "0" + mouth;
		}
		String day = (int) (Math.random() * (28 - 1) + 1) + "";
		if (day.length() == 1) {
			day = "0" + day;
		}
		return year + "-" + mouth + "-" + day;
	}
}
