package controller;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.Events;
import model.Staff;

@Entity
@Table(name = "STAFF_IN_EVENT")
public class Staff_In_Events {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EVENT_ID")
	private int id;
	@Column(name = "STAFF_ID")
	private int staffId;
	@Column(name = "EVENT_DATE")
	private LocalDate eventDate;
	private Staff staff;
	
	public Staff_In_Events(int id, int staffId, LocalDate eventDate, Staff staff) {
		this.id = id;
		this.staffId = staffId;
		this.staff = staff;
		this.eventDate = eventDate;
	}
	
	public Staff_In_Events(LocalDate eventDate, Staff staff) {
		this.staff = staff;
		this.eventDate = eventDate;
	}
	
	public Staff_In_Events(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
	
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
