package UnicornPhoenix.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UnicornPhoenix.Database.MedicalHistory;
import UnicornPhoenix.Database.UnicornPhoenixDB;


/**
 * Servlet implementation class AddMedHistory
 */
@WebServlet("/AddMedHistory")
public class AddMedHistory extends Master {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMedHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		body.append( "<form id=addMedHistory>");
		body.append("<div class='form-inline'><label for='height'>Current Height</label><input type='text' class='form-control' id='height' name='height' placeholder='72 inches' required></div></br>");
		body.append("<div class='form-inline'><label for='weight'>Current Weight</label><input type='text' class='form-control' id='weight' name='weight' placeholder='140lbs' required></div></br>");
		body.append("<div class='form-inline'><label for='bloodtype' required>Blood Type </label>"+
			    "<select id='Select' name='bloodtype' class='form-control'>"+
			    "<option value='o+'>O+</option>"+
			    "<option value='o-'>O-</option>"+
			    "<option value='A+'>A+</option>"+
			    "<option value='A-'>A-</option>"+
			    "<option value='B+'>B+</option>"+
			    "<option value='B-'>B-</option>"+
			    "<option value='AB+'>AB+</option>"+
			    "<option value='AB-'>AB-</option>"+
			    "</select></div>");
		body.append("<div class='form-group'><button type='submit' class='btn btn-default'>Submit</button></div></form>");
		
		super.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// setting to database
		MedicalHistory m = new MedicalHistory();
		m.setBloodType(request.getParameter("bloodtype"));
		int cw = 0;
		try {
			cw = Integer.parseInt(request.getParameter("weight"));
			}
		catch (Exception e){}
		
		m.setCurrentWeight(cw);
		
		int ch = 0;
		try {
			ch = Integer.parseInt(request.getParameter("height"));
			}
		catch (Exception e){}
		m.setCurrentHeight(ch);
		
		m.setPersonID(1);

		UnicornPhoenixDB db = new UnicornPhoenixDB();
		if(request.getParameter("id") != null)
		{
			int id = Integer.parseInt(request.getParameter("id"));
			m.setMedicalHistoryID(id);
			System.out.println(m.toString());
			db.updateMedicalHistory(m);
		}
		else
		{
			db.addMedicalHistory(m);
		}
		
	}

}