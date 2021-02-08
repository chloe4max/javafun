package epita.java.lethao.datamodel.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import epita.java.lethao.datamodel.Person;

public class PersonCSVDAO {
	public List<Person> readAll(File file){
		try {
			List<String> lines = Files.readAllLines(file.toPath());
			lines.remove(0);
			List<Person> personList = new ArrayList<Person>();
			for (String line: lines) {
				String[] personData = line.split(",");
				String name = personData[0].trim().replace("\"","");
				String sex = personData[1].trim().replace("\"","");
				int age = Integer.parseInt(personData[2].trim());
				int height = Integer.parseInt(personData[3].trim());
				int weight = Integer.parseInt(personData[4].trim());
				Person p = new Person(name, sex, age, height, weight);
				personList.add(p);
			}
			Collections.sort(personList, new sortByHeight());
			return personList;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	
	
	public void writeAll(List<Person> persons) {
		try {
			FileWriter fileWriter = new FileWriter("C:\\Users\\letha\\Downloads\\data_outphut2.csv");
			String firstLine = "\"Name\", \"Height (in)\", \"Weight (lbs)\", \"Age\", \"Sex\"\n";
			fileWriter.append(firstLine);
			for(Person person: persons) {
				String name = "\"" + person.getName() + "\",";
				String height = Integer.toString(person.getHeight()) + ",";
				String weight = Integer.toString(person.getWeight()) + ",";
				String age = Integer.toString(person.getAge()) + ",";
				String sex = "\"" + person.getSex() + "\"";
				String line = name + height + weight + age + sex + "\n";
				fileWriter.append(line);
			}
			fileWriter.close();;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
