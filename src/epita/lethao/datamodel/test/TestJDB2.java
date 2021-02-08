package epita.lethao.datamodel.test;

import java.io.File;
import java.util.List;

import epita.java.lethao.datamodel.Person;
import epita.java.lethao.datamodel.dao.PersonCSVDAO;
import epita.java.lethao.datamodel.dao.PersonJDBCDAO;

public class TestJDB2 {
	public static void test() {
		File file = new File ("C:\\Users\\letha\\Downloads\\data.csv");
	    PersonCSVDAO personCsv = new PersonCSVDAO();
		List<Person> personList1 = personCsv.readAll(file);
		PersonJDBCDAO personDao = new PersonJDBCDAO();
		for (Person person1: personList1) {
			personDao.create(person1);	
		}
		List<Person> personList2 = personDao.seach();
		System.out.println("List for Person from SQL Database:");
		for (Person person2: personList2) {
			System.out.println(person2.toString());
		}
	}
}
