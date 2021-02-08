package epita.java.lethao.datamodel.dao;

import java.util.Comparator;

import epita.java.lethao.datamodel.Person;

public class sortByHeight implements Comparator<Person> {
	public int compare(Person p1, Person p2) {
		if (p1.getHeight() > p2.getHeight()) {
			return 1;
		}else if(p1.getHeight() < p2.getHeight()){
			return -1;
		}else {
			return 0;
		}
	}

}
