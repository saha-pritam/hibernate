package org.pritam.hibernate.topic11;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Mobiles")
public class Mobile {
	@Id
	@Column(name="MobileNo")
	private String mobileNumber;
	
	@ManyToOne
	private Person person;

	public Mobile() {
		super();
	}

	public Mobile(String mobileNumber) {
		super();
		this.mobileNumber = mobileNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Mobile [mobileNumber=" + mobileNumber + ", PersonId=" + person.getId() +", PersonName=" + person.getName() + "]";
	}	
}
