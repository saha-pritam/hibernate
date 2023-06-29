package org.pritam.hibernate.topic8;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Pan")
public class Pan {
	@Id
	@Column(name="PAN")
	private String pan;
	@Column(name="Name")
	private String name;
	@OneToOne
	private Aadhar aadhar;
	public Pan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pan(String pan, String name, Aadhar aadhar) {
		super();
		this.pan = pan;
		this.name = name;
		this.aadhar = aadhar;
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
	public Aadhar getAadhar() {
		return aadhar;
	}
	public void setAadhar(Aadhar aadhar) {
		this.aadhar = aadhar;
	}
	@Override
	public String toString() {
		return "Pan [pan=" + pan + ", name=" + name + ", aadhar=" + aadhar + "]";
	}
}
