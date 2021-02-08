package epita.java.lethao.datamodel;

public class Person {
	String name;
	String sex;
	int age;
	int height;
	int weight;
	
	public Person(String name, String sex, int age, int height, int weight) {
		super();
		this.name = name;
		checkSex(sex);
		this.sex = sex;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public void checkSex(String sex) {
		if (!(sex.equals("M")) && !(sex.equals("F"))) {
			throw new RuntimeException("Sex must be \"F\" or \"M\"");
		}
	}
	
	public String toString() {
		return "Person [name=\"" + this.name + "\", height=\"" + this.height +"\"]";
	}

}
