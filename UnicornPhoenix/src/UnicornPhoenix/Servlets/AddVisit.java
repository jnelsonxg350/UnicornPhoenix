package UnicornPhoenix.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import UnicornPhoenix.Database.UnicornPhoenixDB;
import UnicornPhoenix.Database.Visit;

/**
 * Servlet implementation class Visit
 */
@WebServlet("/Visit")
public class AddVisit extends Master {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddVisit() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UnicornPhoenixDB db = new UnicornPhoenixDB();
		Visit v = db.getVisit(request.getParameter("VisitID"));
		if (v.getDateOfVisit() == null)

		{
			body.append("<form id='VisitForm' data-toggle='validator'>");
			body.append("<div class='form-inline'><label for='dateofvisit'>Date of Visit:</label><input type='date' class='form-control' id='visitdate'name='visitdate' required></div></br>");
			body.append("<div class='form-inline'><label for='height'>Height</label><input type='text' class='form-control' id='height' placeholder='(inches)ex.(72)' name='height' required></div></br>");
			body.append("<div class='form-inline'><label for='weight'> Weight</label><input type='text' class='form-control' id='weight' placeholder='150' name='weight' required></div></br>");
			body.append("<div class='form-inline'><label for='bloodpressure'> Blood Pressure</label><input type='text' class='form-control' id='bloodpressure' placeholder='110/70' name='bloodpressure' required></div></br>");
			body.append("<div class='form-inline'>"
					+ "<label for='visittype'>select one: </label>"
					+ "<select id='Select' class='form-control' name='visitType' >"
					+ "<option value='walkin'name='walkin'>Walk-in</option>"
					+ "<option value='checkup'name='checkup'>Check-up</option>"
					+ "<option value='Emergency'name='emergency'>Emergency</option>"
					+ "</select></div></br>");
			body.append("<div class='form-group'><label for='result'> Result of the Visit</label><input type='text' class='form-control' id='result' placeholder='please describe the result of the visit'name='result' required></div></br>");

			body.append("</div>"
					+ "<div class='form-group'>"
					+ "<button type='submit' class='btn btn-default'>Submit</button></div></form>");
		} 
		else 
		{
			body.append("<input type='hidden' value='" + v.getVisitID()
					+ "' name='VisitID'/>");
			body.append("<input type='hidden' value='" + v.getPersonID()
					+ "' name='id'/>");
			body.append("<div class='form-inline'><label for='dateofvisit'>Date of Visit:</label><input type='date' class='form-control' id='visitdate'name='visitdate' required></div></br>");
			body.append("<div class='form-inline'><label for='height'>Height</label><input type='text' class='form-control' id='height' placeholder='(inches)ex.(72)' name='height' required></div></br>");
			body.append("<div class='form-inline'><label for='weight'> Weight</label><input type='text' class='form-control' id='weight' placeholder='150' name='weight' required></div></br>");
			body.append("<div class='form-inline'><label for='bloodpressure'> Blood Pressure</label><input type='text' class='form-control' id='bloodpressure' placeholder='110/70' name='bloodpressure' required></div></br>");
			body.append("<div class='form-inline'>"
					+ "<label for='visittype'>select one: </label>"
					+ "<select id='Select' class='form-control' name='visitType' >"
					+ "<option value='walkin'name='walkin'>Walk-in</option>"
					+ "<option value='checkup'name='checkup'>Check-up</option>"
					+ "<option value='Emergency'name='emergency'>Emergency</option>"
					+ "</select></div></br>");
			body.append("<div class='form-group'><label for='result'> Result of the Visit</label><input type='text' class='form-control' id='result' placeholder='please describe the result of the visit'name='result' required></div></br>");

			body.append("</div>"
					+ "<div class='form-group'>"
					+ "<button type='submit' class='btn btn-default'>Submit</button></div></form>");
		}

		super.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// setting to database
		Visit v = new Visit();
		int ch = 0;
		try {
			ch = Integer.parseInt(request.getParameter("height"));
		} catch (Exception e) {
		}
		v.setHeight(ch);

		int cw = 0;
		try {
			cw = Integer.parseInt(request.getParameter("weight"));
		} catch (Exception e) {
		}
		v.setWeight(cw);

		int bp = 0;
		try {
			bp = Integer.parseInt(request.getParameter("bloodpressure"));
		} catch (Exception e) {
		}
		v.setBloodPressure(bp);

		v.setType(request.getParameter("visittype"));
		v.setResult(request.getParameter("result"));
		v.setPersonID(1);

		UnicornPhoenixDB db = new UnicornPhoenixDB();
		if (request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			v.setVisitID(id);
			System.out.println(v.toString());
			db.updateVisit(v);
		} else {
			db.addVisit(v);
		}
	}
}
