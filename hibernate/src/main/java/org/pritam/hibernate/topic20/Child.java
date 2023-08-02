package org.pritam.hibernate.topic20;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Children")
@Getter
@Setter
public class Child {
	@Id
	@Column(name="CID")
	private int cid;
	
	@Column(name="VALUE")
	private String val;
	
	@ManyToMany
	@JoinTable(name="childparent",joinColumns = @JoinColumn(name="CID", referencedColumnName = "cid"),inverseJoinColumns = @JoinColumn(name="PID",referencedColumnName = "pid"))
	private List<Parent> parent;
	
	public Child(int cid, String val) {
		super();
		this.cid = cid;
		this.val = val;
	}
	
	public Child() {
		super();
		// TODO Auto-generated constructor stub
	}
}
