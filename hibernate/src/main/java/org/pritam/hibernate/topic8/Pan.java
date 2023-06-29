package org.pritam.hibernate.topic8;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Pan")
public class Pan {
	@Id
	@Column(name="PAN")
	private String pan;
	@Column(name="Name")
	private String name;
	public Pan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pan(String pan, String name) {
		super();
		this.pan = pan;
		this.name = name;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Pan [pan=" + pan + ", name=" + name + "]";
	}
}
