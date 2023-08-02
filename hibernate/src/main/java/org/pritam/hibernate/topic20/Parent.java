package org.pritam.hibernate.topic20;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Parents")
@Getter
@Setter
@AllArgsConstructor
public class Parent {
	@Id
	@Column(name="PID")
	private int pid;
	
	@Column(name="VALUE")
	private String val;
	
	@ManyToMany(mappedBy="parent", cascade=CascadeType.ALL)
	private List<Child> children;

	public Parent(int pid, String val) {
		super();
		this.pid = pid;
		this.val = val;
	}

	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}
}
