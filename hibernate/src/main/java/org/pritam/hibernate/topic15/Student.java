package org.pritam.hibernate.topic15;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name) {
		super();
		this.name = name;
	}
	
	public Student(int sid, String name) {
		super();
		this.sid = sid;
		this.name = name;
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

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + "]";
	}
}
