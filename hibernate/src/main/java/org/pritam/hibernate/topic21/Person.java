package org.pritam.hibernate.topic21;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Person")
@NoArgsConstructor
@Getter
@Setter
@ToString

@NamedQueries({
	@NamedQuery(name = "getById", query = "from Person where id=:param"),
	@NamedQuery(name = "getAll", query = "from Person")
})
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PID")
	private int id;
	@Column(name="FIRSTNAME")
	private String firstName;
	@Column(name="LASTNAME")
	private String lastName;
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
