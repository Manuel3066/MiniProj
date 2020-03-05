package controller;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.Events;

@Entity
@Table(name = "staff_in_events")
public class Staff_In_Events {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EVENT_ID")
	private int id;
	@Column(name = "STAFF_ID")
	private int staffId;
	private Events events;
	public Staff_In_Events() {
		super();
		
	}
	
	//public Staff_In_Events(String eventName) {
		//super();

		//}
	//}

	@OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinTable
	(
		name="STAFF_IN_EVENT",
		joinColumns={ @JoinColumn(name="STAFF_ID", referencedColumnName="STAFF_ID") },
		inverseJoinColumns={ @JoinColumn(name="EVENT_ID", referencedColumnName="ID", unique=true)}
			
	)	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
}
