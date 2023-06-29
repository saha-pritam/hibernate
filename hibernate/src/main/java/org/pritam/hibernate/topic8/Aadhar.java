package org.pritam.hibernate.topic8;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Aadhar")
public class Aadhar {
	@Id
	@Column(name="UID")
	private String uid;
	@Column(name="Name")
	private String name;
	@OneToOne
	@JoinTable(name = "UID_PAN",joinColumns = @JoinColumn(name="UID",referencedColumnName = "uid"),inverseJoinColumns = @JoinColumn(name="PAN",referencedColumnName = "pan"))
	private Pan pan;
	public Aadhar() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Aadhar(String uid, String name, Pan pan) {
		super();
		this.uid = uid;
		this.name = name;
		this.pan = pan;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Pan getPan() {
		return pan;
	}
	public void setPan(Pan pan) {
		this.pan = pan;
	}
	@Override
	public String toString() {
		return "Aadhar [uid=" + uid + ", name=" + name + ", pan=" + pan + "]";
	}
}
