package epita.lethao.datamodel.test;

import java.util.LinkedList;
import java.util.List;

import epita.java.lethao.datamodel.Person;

public class ArrayTest {

	public static void test()
	{
		int [][] array2D = new int[8][8];
		int i = 0;
		for (int row = 0; row < array2D.length; row++)
		{
			for (int col = 0; col < array2D[row].length; col++)
			{
				array2D[row][col] = i;
				i++;
			}
		}
		
		for (int row = 0; row < array2D.length; row++)
		{
			for (int col = 0; col < array2D[row].length; col++)
			{
				System.out.print(array2D[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	public static void test2()
	{
		List<Person> persons = new LinkedList<>();
		Person [][] array2D = new Person[8][8];
		for (int i = 0; i < persons.size(); i++)
		{
			int row = i / 8;
			int col = i % 8;
			array2D[row][col] = persons.get(i);
		}
	}
	
	public static void main(String [] args)
	{
		test();
	}
}
