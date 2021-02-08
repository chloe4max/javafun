package epita.lethao.datamodel.test;

import java.io.File;
import java.util.List;

import epita.java.lethao.datamodel.Person;
import epita.java.lethao.datamodel.dao.PersonCSVDAO;
import epita.java.lethao.datamodel.service.PersonDataService;

public class TestBLI1 {
	public static void test() {
		File file = new File("C:\\Users\\letha\\Downloads\\data.csv");
		PersonCSVDAO personCsv = new PersonCSVDAO();
		List<Person> personList = personCsv.readAll(file);
		PersonDataService personService = new PersonDataService();
		System.out.println("Average age of Person List: ");
		System.out.println(personService.averageAge(personList));
		System.out.println("List of people above 32 years old: ");
		List<Person> personFilter = personService.filter(personList, 32);
		for(Person p: personFilter) {
			System.out.println(p.toString());
		}
		System.out.println("YOB of Alex");
		System.out.println(personService.calculateYearOfBirth(personList.get(16)));
		System.out.println("Distribution of age of person List: ");
		System.out.println(personService.ageGroup(personList));
		
	}
}
