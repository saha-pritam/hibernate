package org.pritam.hibernate.topic19;

public class Student {
	private int sid;
	private String name;
	private String std;
	private int mark;
	private String gender;
	
	public Student() {
		super();
	}

	public Student(String name, String std, int mark, String gender) {
		super();
		this.name = name;
		this.std = std;
		this.mark = mark;
		this.gender = gender;
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
