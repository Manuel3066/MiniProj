package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Staff;

/**
 * Servlet implementation class createNewEventServlet
 */
@WebServlet("/createNewEventServlet")
public class createNewEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListItemHelper lih = new ListItemHelper();
		String eventName = request.getParameter("eventName");
		System.out.println("Event name: " + eventName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String staffName = request.getParameter("staffName");
		String staffPosition = request.getParameter("staffPosition");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch(NumberFormatException ex){
			ld = LocalDate.now();
		}
		
		String[] selectedStaff = request.getParameterValues("allStaffToAdd");
		
		List<Staff> selectedStaffInList = new ArrayList<Staff>();
		
		if (selectedStaff != null && selectedStaff.length > 0) {
			for(int i = 0; i<selectedStaff.length; i++) {
				System.out.println(selectedStaff[i]);
				Staff s = lih.searchForStaffById(Integer.parseInt(selectedStaff[i]));
				selectedStaffInList.add(s);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
