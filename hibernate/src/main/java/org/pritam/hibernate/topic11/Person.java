package org.pritam.hibernate.topic11;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Persons")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PersonID")
	private int id;
	
	@Column(name="PersonName")
	private String name;
	
	@OneToMany(mappedBy="person")
	private List<Mobile> numbers;

	public Person() {
		super();
	}

	public Person(String name) {
		super();
		this.name = name;
		this.numbers = new ArrayList<Mobile>();
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

	public List<Mobile> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Mobile> numbers) {
		this.numbers = numbers;
	}

	@Override
	public String toString() {
		String s = "Person [id=" + id + ",\nname=" + name + ",\nnumbers=";
		String seperator="";
		for(Mobile mobile:numbers) {
			s = s + seperator+ " " + mobile.getMobileNumber();
			seperator=",";
		}
		s = s + "].";
		return s;
	}
	
	
}
