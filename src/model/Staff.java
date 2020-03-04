package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STAFF_ID")
	private int id;
	@Column(name = "STAFF_NAME")
	private String staffName;
	@Column(name = "STAFF_POSITION")
	private String staffPosition;

	public Staff() {
		super();
	}

	public Staff(int id, String staffName, String staffPosition) {
		super();
		this.id = id;
		this.staffName = staffName;
		this.staffPosition = staffPosition;
	}

	public Staff(String staffName, String staffPosition) {
		super();
		this.staffName = staffName;
		this.staffPosition = staffPosition;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffPosition() {
		return staffPosition;
	}

	public void setStaffPosition(String staffPosition) {
		this.staffPosition = staffPosition;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", staffName=" + staffName + ", staffPosition=" + staffPosition + "]";
	}
}