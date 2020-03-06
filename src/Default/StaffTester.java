package Default;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.EventHelper;
import controller.LocalDateAttributeConverter;
import controller.StaffHelper;
import controller.Staff_In_Events;
import model.Events;
import model.Staff;

public class StaffTester {

	public static void main(String[] args) {
		Events Jumps = new Events();
		
		StaffHelper sh = new StaffHelper();
		
		Staff john = new Staff("John", "Janitor");
		Staff henry = new Staff("Henry", "Lighting");

		List<Staff> JumpStaff = new ArrayList<Staff>();
		JumpStaff.add(john);
		JumpStaff.add(henry);

		LocalDate d = LocalDate.of(2015, 12, 22);
		Staff_In_Events StaffList = new Staff_In_Events(5, 0, d, henry);

		sh.insertStaff(JumpStaff);
		
		List<Staff> allStaff = sh.showAllStaff();
		
		for (Staff a : allStaff) {
			System.out.println(a.toString());
		}

	}

}
