package Default;

import java.util.List;

import controller.StaffHelper;
import model.Staff;

public class StaffTester {

	public static void main(String[] args) {
		Staff John = new Staff("John", "Janitor");
		
		StaffHelper sh = new StaffHelper();

		sh.insertStaff(John);

		List<Staff> allStaff = sh.showAllStaff();
		for (Staff a : allStaff) {
			System.out.println(a.toString());
		}

	}

}
