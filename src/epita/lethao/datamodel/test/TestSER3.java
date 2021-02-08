package epita.lethao.datamodel.test;

import java.io.File;
import java.util.List;

import epita.java.lethao.datamodel.Person;
import epita.java.lethao.datamodel.dao.PersonCSVDAO;

public class TestSER3 {
	public static void test() {
		File file = new File ("C:\\Users\\letha\\Downloads\\data.csv");
	    PersonCSVDAO personCsv = new PersonCSVDAO();
		List<Person> personList = personCsv.readAll(file);
		personCsv.writeAll(personList);
		System.out.println("Write to File Completed");
	}

}
