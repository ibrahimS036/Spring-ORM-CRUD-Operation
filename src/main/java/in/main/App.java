package in.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.StudentDao;
import entities.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("Welcome To My  Spring ORM Application...");

		ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
		StudentDao dao = context.getBean("mainObject", StudentDao.class);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;
		while (go) {
			System.out.println("--------------------------------------------------------");
			System.out.println("PRESS 1 for add new  Student:");
			System.out.println("PRESS 2 for Display all Student:");
			System.out.println("PRESS 3 for get details of single Student:");
			System.out.println("PRESS 4 for update Student:");
			System.out.println("PRESS 5 for delete Student:");
			System.out.println("PRESS 6 for exit:");

			try {
				int userChoice = Integer.parseInt(br.readLine());
				switch (userChoice) {
				case 1:
					System.out.println("Enter Student Id :");
					int inputId = Integer.parseInt(br.readLine());

					System.out.println("Enter Student Name :");
					String inputName = br.readLine();

					System.out.println("Enter Student city :");
					String inputCity = br.readLine();

					Student s = new Student();
					s.setStudentId(inputId);
					s.setStudentName(inputName);
					s.setStudentCity(inputCity);

					int insertedStudent = dao.insertStudent(s);
					System.out.println(insertedStudent + ":Student Added.");

					break;
				case 2:
					System.out.println("****************************************");
					List<Student> all = dao.getAll();
					for (Student st : all) {
						System.out.println("ID:" + st.getStudentId());
						System.out.println("Name:" + st.getStudentName());
						System.out.println("City:" + st.getStudentCity());
						System.out.println("______________________");
					}
					break;
				case 3:
					System.out.println("Enter Id To get Student.");
					int newId = Integer.parseInt(br.readLine());
					Student byId = dao.getById(newId);
					System.out.println(byId);
					break;
				case 4:
					Student updt = new Student();
					updt.setStudentId(24);
					updt.setStudentName("Yunus");
					updt.setStudentCity("Delhi");
					dao.updateStudent(updt);
					System.out.println("Student Update Successfully.");
					break;
				case 5:
					System.out.println("Enter Id To Delete Student");
					int newID = Integer.parseInt(br.readLine());
					dao.deleteStudent(newID);
					System.out.println("Student Data Deleted Successfully.");

					break;
				case 6:
					go = false;
					break;
				}

			} catch (Exception e) {
				System.out.println("Invalid Input Try with another one !!");
				System.out.println(e.getMessage());
			}

		}
		System.out.println("Thank You for Using My Application.");
		System.out.println("See You Soon !!");

	}
}
