package org.pritam.hibernate.topic8;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Aadhar")
public class Aadhar {
	@Id
	@Column(name="UID")
	private String uid;
	@Column(name="Name")
	private String name;
	public Aadhar() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Aadhar(String uid, String name) {
		super();
		this.uid = uid;
		this.name = name;
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
	@Override
	public String toString() {
		return "Aadhar [uid=" + uid + ", name=" + name + "]";
	}
}
