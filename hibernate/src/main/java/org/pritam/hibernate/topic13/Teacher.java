package org.pritam.hibernate.topic13;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Teachers")
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TId")
	private int tid;
	
	@Column(name="Name")
	private String name;
	
	@ManyToMany
	@JoinTable(name="TeacherStudent",joinColumns = @JoinColumn(name="TID",referencedColumnName = "tid"),inverseJoinColumns = @JoinColumn(name="SID",referencedColumnName = "sid"))
	private List<Student> students;

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(String name) {
		super();
		this.name = name;
		this.students = new ArrayList<Student>();
	}

	public int getId() {
		return tid;
	}

	public void setId(int tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		String s =  "Teacher [id=" + tid + ", name=" + name + ",\nStudents :- {";
		for(Student student:students)
			s = s + "\n" + student.getName();
		s = s + "\n}]";
		return s;
	}
}
