package model;


public class Employee {
	private String id, name;
	private int age;

	public Employee(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
}
