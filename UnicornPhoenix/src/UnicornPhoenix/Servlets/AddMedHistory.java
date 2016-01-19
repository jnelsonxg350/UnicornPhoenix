package UnicornPhoenix.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		body.append("<div class='form-inline'><label for='height'>Current Height</label><input type='text' class='form-control' id='height' placeholder='5 feet 6 inches'></div></br>");
		body.append("<div class='form-inline'><label for='weight'>Current Weight</label><input type='text' class='form-control' id='weight' placeholder='140lbs'></div></br>");
		body.append("<div class='form-inline'><lbel for='bloodtype'>Blood Type </label>"+
			    "<select id='Select' class='form-control'>"+
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
