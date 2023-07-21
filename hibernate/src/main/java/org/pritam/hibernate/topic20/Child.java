package org.pritam.hibernate.topic20;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Children")
@Getter
@Setter
@NoArgsConstructor
public class Child {
	@Id
	@Column(name="CID")
	private int cid;
	
	@Column(name="VALUE")
	private String val;
	
	@OneToOne
	@JoinColumn(name="PID", referencedColumnName = "pid")
	private Parent parent;

	public Child(int cid, String val) {
		super();
		this.cid = cid;
		this.val = val;
	}
}
