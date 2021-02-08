package epita.java.lethao.datamodel.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TreeMap;

import epita.java.lethao.datamodel.Person;

public class PersonDataService {
	public int averageAge(List<Person> persons) {
		int sum = 0;
		int count = 0;
		for (Person p: persons) {
			sum = + p.getAge();
			count = + 1;
		}
		int averageAge = sum/count;
		return averageAge;
	}
	
	public List<Person> filter(List<Person> persons, int thresholdAge){
		List<Person> filterList = new ArrayList<Person>();
		for (Person p: persons) {
			if (p.getAge() > thresholdAge) {
				filterList.add(p);
			}
		}
		return filterList;
	}
	
	public int calculateYearOfBirth(Person person) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int YOB = currentYear - person.getAge();
		return YOB;
	}
	
	public TreeMap<Integer,Integer> ageGroup(List<Person> persons){
		TreeMap<Integer,Integer> ageGroup = new TreeMap<Integer,Integer>();
		for(Person p: persons) {
			if(ageGroup.containsKey(p.getAge())) {
				int count = ageGroup.get(p.getAge()) + 1;
				ageGroup.put(p.getAge(), count);
			}else {
				ageGroup.put(p.getAge(), 1);
			}			
		}
		return ageGroup;
	}

}
