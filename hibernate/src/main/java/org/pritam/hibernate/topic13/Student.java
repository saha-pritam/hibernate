package org.pritam.hibernate.topic13;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Students")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SId")
	private int sid;
	
	@Column(name="Name")
	private String name;
	
	@ManyToMany(mappedBy="students")
	private List<Teacher> teachers;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name) {
		super();
		this.name = name;
		this.teachers = new ArrayList<Teacher>();
	}

	public int getId() {
		return sid;
	}

	public void setId(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		String s = "Student [id=" + sid + ", name=" + name + ",\n Teachers :- {";
		for(Teacher teacher:teachers)
			s = s + "\n" + teacher.getName();
			s = s + "\n}]";
		return s;
	}
}
