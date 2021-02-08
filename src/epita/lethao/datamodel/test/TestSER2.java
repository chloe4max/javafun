package epita.lethao.datamodel.test;

import java.io.File;
import java.util.List;

import epita.java.lethao.datamodel.Person;
import epita.java.lethao.datamodel.dao.PersonCSVDAO;

public class TestSER2 {
	public static void test() {
	    File file = new File ("C:\\Users\\letha\\Download\\data.csv");
	    PersonCSVDAO personCsv = new PersonCSVDAO();
		List<Person> personList = personCsv.readAll(file);
		System.out.println("List of Person sorted by Height");
		for (Person p : personList) {
			System.out.println(p.toString());
		}
	}
}
