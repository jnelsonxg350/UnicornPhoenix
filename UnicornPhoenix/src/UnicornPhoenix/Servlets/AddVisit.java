package UnicornPhoenix.Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
@WebServlet("/AddVisit")
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
			int id = Integer.parseInt(request.getParameter("id"));
			body.append("<form id='VisitForm'>");
			body.append("<input type='hidden' value='" + id + "' name='id'/>");
			body.append("<div class='form-group'><label for='dateofvisit'>Date of Visit:</label><input type='date' class='form-control' id='visitdate'name='visitdate' required></div></br>");
			body.append("<div class='form-group'><label for='height'>Height</label><input type='text' class='form-control' id='height' placeholder='(inches)ex.(72)' name='height' required></div></br>");
			body.append("<div class='form-group'><label for='weight'> Weight</label><input type='text' class='form-control' id='weight' placeholder='150' name='weight' required></div></br>");
			body.append("<div class='form-group'><label for='bloodpressure'> Blood Pressure</label><input type='text' class='form-control' id='bloodpressure' placeholder='110/70' name='bloodpressure' required></div></br>");
			body.append("<div class='form-group'>"
					+ "<label for='visittype'>Type of Visit: </label>"
					+ "<select id='Select' class='form-control' name='visitType' required>"
					+ "<option value='' name='visitType'>Select One</option>"
					+ "<option value='walkin' name='visitType'>Walk-in</option>"
					+ "<option value='checkup' name='visitType'>Check-up</option>"
					+ "<option value='Emergency' name='visitType'>Emergency</option>"
					+ "</select></div></br>");
			body.append("<div class='form-group'><label for='result'> Result of the Visit</label><input type='text' class='form-control' id='result' placeholder='please describe the result of the visit' name='result' required></div></br>");

			body.append("<div class='form-group'>"
					+ "<button type='submit' class='btn btn-default'>Submit</button></div></form>");
		} 
		else 
		{
			body.append("<form id='VisitForm'>");
			body.append("<input type='hidden' value='" + v.getVisitID()
					+ "' name='VisitID'/>");
			body.append("<input type='hidden' value='" + v.getPersonID()
					+ "' name='id'/>");
			body.append("<div class='form-group'><label for='dateofvisit'>Date of Visit:</label><input type='date' class='form-control' id='visitdate'name='visitdate' value="+v.getDateOfVisit()+"></div></br>");
			body.append("<div class='form-group'><label for='height'>Height</label><input type='text' class='form-control' id='height' placeholder='(inches)ex.(72)' name='height' value="+v.getHeight()+"></div></br>");
			body.append("<div class='form-group'><label for='weight'> Weight</label><input type='text' class='form-control' id='weight' placeholder='150' name='weight' value="+v.getWeight()+"></div></br>");
			body.append("<div class='form-group'><label for='bloodpressure'> Blood Pressure</label><input type='text' class='form-control' id='bloodpressure' placeholder='110/70' name='bloodpressure' value="+v.getBloodPressure()+"></div></br>");
			body.append("<div class='form-group'>"
					+ "<label for='visittype'>select one: </label>"+' '+v.getType()
					+ "<select id='Select' class='form-control' name='visitType' required>"
					+ "<option value='walkin'name='visitType'>Walk-in</option>"
					+ "<option value='checkup'name='visitType'>Check-up</option>"
					+ "<option value='Emergency'name='visitType'>Emergency</option>"
					+ "</select></div></br>");
			body.append("<div class='form-group'><label for='result'> Result of the Visit</label>"+' '+v.getResult()+
					"<input type='text' class='form-control' id='result' placeholder='please describe the result of the visit'name='result' required></div></br>");

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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {		
			
			Date d = sdf.parse(request.getParameter("visitdate"));
			java.sql.Date sqlDate = new java.sql.Date(d.getTime());
			v.setDateOfVisit(sqlDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

		v.setBloodPressure(request.getParameter("bloodpressure"));

		v.setType(request.getParameter("visitType"));
		v.setResult(request.getParameter("result"));
		
		// TODO Attach to a person
		int PersonID = Integer.parseInt(request.getParameter("id"));
		v.setPersonID(PersonID);

		UnicornPhoenixDB db = new UnicornPhoenixDB();
		if (request.getParameter("VisitID") != null) {
			int id = Integer.parseInt(request.getParameter("VisitID"));
			v.setVisitID(id);
			System.out.println(v.toString());
			db.updateVisit(v);
		} else {
			db.addVisit(v);
		}
	}
}
