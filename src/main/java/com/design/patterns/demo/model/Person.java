package com.design.patterns.demo.model;

public class Person {
	private int id;
	private String name;
	private String password;
	
	public Person() {
		
	}

	public Person(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public Person(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Person person = (Person) o;

		if (name != null ? !name.equals(person.name) : person.name != null) return false;
		return password != null ? password.equals(person.password) : person.password == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (password != null ? password.hashCode() : 0);
		return result;
	}
}
