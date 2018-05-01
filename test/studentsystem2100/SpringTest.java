package studentsystem2100;

import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tim.generator.NameGenerator;
import com.training.form.StudentForm;
import com.training.service.StudentService;

public class SpringTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");

		StudentService service = context.getBean(StudentService.class);
		for (int i = 0; i < 100; i++) {
			StudentForm form = new StudentForm();
			form.setName(NameGenerator.generatorNoramlName());
			form.setClazz(Integer.toString((int) (Math.random() * (30 - 10) + 10)));
			String date = createRandomDate();
			form.setBirthday(date);
			service.saveStudent(form);
		}
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
