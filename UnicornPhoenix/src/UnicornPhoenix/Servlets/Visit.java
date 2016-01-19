package UnicornPhoenix.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Visit
 */
@WebServlet("/Visit")
public class Visit extends Master {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Visit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		body.append("<div class='form-inline'><label for='dateofvisit'>Date of Visit:</label><input type='date' class='form-control' id='visitdate'name='visitdate' ></div></br>");
		body.append("<div class='form-inline'><label for='height'>Height</label><input type='text' class='form-control' id='height' placeholder='(feet.inches)ex.(5.4)' name='height'></div></br>");
		body.append("<div class='form-inline'><label for='weight'> Weight</label><input type='text' class='form-control' id='weight' placeholder='150' name='weight'></div></br>");
		body.append("<div class='form-inline'><label for='bloodpressure'> Blood Pressure</label><input type='text' class='form-control' id='bloodpressure' placeholder='110/70' name='bloodpressure'></div></br>");
		body.append("<div class='form-inline'>"+
				"<label for='visittype'>select one: </label>"+
			    "<select id='Select' class='form-control' name='visitType' >"+
			    "<option value='walkin'name='walkin'>Walk-in</option>"+
			    "<option value='checkup'name='checkup'>Check-up</option>"+
			    "<option value='Emergency'name='emergency'>Emergency</option>"+
			    "</select></div></br>");
		body.append("<div class='form-group'><label for='result'> Result of the Visit</label><input type='text' class='form-control' id='result' placeholder='please describe the result of the visit'name='result'></div></br>");

		body.append("</div>"+
		    	"<div class='form-group'>"+
		    		"<button type='submit' class='btn btn-default'>Submit</button></div></form>");
		super.doGet(request, response);
	
	
	
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
