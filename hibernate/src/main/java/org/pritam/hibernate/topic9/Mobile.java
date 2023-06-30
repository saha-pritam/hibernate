package org.pritam.hibernate.topic9;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Mobiles")
public class Mobile {
	@Id
	@Column(name="Mobile_No")
	private String mobileNumber;

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
}
