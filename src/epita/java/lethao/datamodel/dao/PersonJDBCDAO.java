package epita.java.lethao.datamodel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import epita.java.lethao.datamodel.Person;

public class PersonJDBCDAO {
	private static final String DATABASE = "jdbc:postgresql://localhost:5432/person-database";
	private static final String INSERT = "INSERT INTO public.\"PERSON2\"(name, sex, age, height, weight) VALUES(%s);";
	private static final String SELECT = "SELECT name, sex, age, height, weight, id FROM public.\"PERSON2\";";
	
	public void create(Person person) {
		try {
			Connection connection = DriverManager.getConnection(DATABASE, "postgres","");
			StringBuilder sb = new StringBuilder();
			sb.append("'" + person.getName() + "',");
			sb.append("'" + person.getSex() + "',");
			sb.append(person.getAge() + ",");
			sb.append(person.getHeight() + ",");
			sb.append(person.getWeight());
			String finalQuery = String.format(INSERT, sb.toString());
			PreparedStatement createStatement = connection.prepareStatement(finalQuery);
			createStatement.execute();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Person> seach() {
		Connection connection;
		try {
			connection = DriverManager.getConnection(DATABASE, "postgres", "");
			PreparedStatement searchStatement = connection.prepareStatement(SELECT);
			ResultSet results =  searchStatement.executeQuery();
			List<Person> persons = new ArrayList<Person> ();
			while(results.next()) {
				String name = results.getString("name");
				String sex = results.getString("sex");
				int age = results.getInt("age");
				int height = results.getInt("height");
				int weight = results.getInt("weight");
				Person p = new Person(name,sex,age,height,weight);
				persons.add(p);
			}
			connection.close();
			return persons;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

		
	}

}
