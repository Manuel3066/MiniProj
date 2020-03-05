package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Events {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EVENT_ID")
	private int id;
	@Column(name = "EVENT_NAME")
	private String eventName;
	@Column(name = "EVENT_DATE")
	private LocalDate eventDate;
	@Column(name = "EVENT_OCCUPANCY")
	private int occupancy;
	@Column(name = "EVENT_PRICE")
	private double price;
	private Staff staff;
	
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Events() {
		super();
	}
	
	public Events(int id, String eventName, LocalDate eventDate, int occupancy, double price) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.occupancy = occupancy;
		this.price = price;
	}

	public Events(Staff staff, String eventName, LocalDate eventDate, int occupancy, double price) {
		super();
		this.staff = staff;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.occupancy = occupancy;
		this.price = price;
	}
	
	public Events(String eventName, LocalDate eventDate, int occupancy, double price) {
		super();
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.occupancy = occupancy;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public int getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Events [id=" + id + ", eventName=" + eventName + ", eventDate=" + eventDate + ", occupancy=" + occupancy
				+ ", price=" + price + ", staff=" + staff + "]";
	}
}