package org.pritam.hibernate.topic18;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name="Students")
public class Student {
	@Id
	@Column(name="Id")
	private int sid;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Class")
	private String std;
	
	@Column(name="Mark")
	private int mark;
	
	@Column(name="Gender")
	private String gender;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", std=" + std + ", mark=" + mark + ", gender=" + gender
				+ "]";
	}
}
