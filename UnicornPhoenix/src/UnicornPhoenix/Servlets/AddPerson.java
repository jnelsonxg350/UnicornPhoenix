package UnicornPhoenix.Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UnicornPhoenix.Database.*;
@WebServlet("/AddPerson")
public class AddPerson extends Master {
	private static final long serialVersionUID = 1L;
    public AddPerson() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UnicornPhoenixDB db = new UnicornPhoenixDB();
		Person p = db.getPerson(request.getParameter("id"));
		
		//Couldn't find a person
		if(p.getLname() == null)
		{
			body.append("<form id='personForm'>");
			body.append("<div class='form-group'><label for='firstname'>First Name</label><input type='text' class='form-control' id='firstname' name='firstname' placeholder='First Name'></div>");
			body.append("<div class='form-group'><label for='middlename'>Middle Name</label><input type='text' class='form-control' id='middleName' placeholder='Middle Name' name='middlename' ></div>");
			body.append("<div class='form-group'><label for='lastname'>Last Name</label><input type='text' class='form-control' id='lastname' name='lastname' placeholder='Last Name'></div>");
			body.append("<div class='form-inline'><label for='dob'>Birth Date:</label><input type='date' class='form-control' id='dob' name='dob'></div>");
			body.append("<div class='form-group'><label for='ssn'>SSN</label><input type='text' class='form-control' id='ssn' name='ssn' placeholder='SSN'></div>");
			body.append("<div class='form-group'><label for='gender'>Gender</label><input type='text' class='form-control' id='gender' name='gender' placeholder='Gender'></div>");
			body.append("<div class='form-group'><label for='gender'>Gender:  </label><input type='radio' id='female' value='female' name='female'>Female<input type='radio' id='male' value='male' name='male'>Male<input type='radio' id='othergender' value='othergender' name='othergender'>Other</div>");
			body.append("<div class='form-inline'>"+
					"<label for='personType'>select one: </label>"+
				    "<select id='Select' class='form-control' name='personType' >"+
				    "<option value='doctor'>Doctor</option>"+
				    "<option value='paitent'>Paitent</option>"+
				    "<option value='provider'>Provider</option>"+
				    "</select></br>");
			
			body.append("<button type='submit' class='btn btn-default'>Submit</button></form>");
		}
		else //found a person display their info
		{
			body.append("<form id='personForm'>");
			body.append("<div class='form-group'><label for='firstname'>First Name</label><input type='text' class='form-control' id='firstname' name='firstname' placeholder='First Name' value='" + p.getFname() + "'></div>");
			body.append("<div class='form-group'><label for='middlename'>Middle Name</label><input type='text' class='form-control' id='middleName' placeholder='Middle Name' value='"+p.getMname()+"' name='middlename' ></div>");
			body.append("<div class='form-group'><label for='lastname'>Last Name</label><input type='text' class='form-control' id='lastname' name='lastname' placeholder='Last Name' value='" + p.getLname() + "'></div>");
			body.append("<div class='form-inline'><label for='dob'>Birth Date:</label><input type='date' class='form-control' id='dob' value='" + p.getDOB().toString() + "' ></div>");
			body.append("<div class='form-group'><label for='ssn'>SSN</label><input type='text' class='form-control' id='ssn' name='ssn' placeholder='SSN' value='" + p.getSSN().toString() + "' ></div>");
			body.append("<div class='form-group'><label for='gender'>Gender</label><input type='text' class='form-control' id='gender' name='gender' placeholder='Gender' value='" + p.getGender() + "' ></div>");
		body.append("<div class='form-inline'>"+
				    "<label for='personType'>select one: </label>"+
				    "<select id='Select' class='form-control' name='personType' >"+
				    "<option value='doctor'>Doctor</option>"+
				    "<option value='paitent'>Paitent</option>"+
				    "<option value='provider'>Provider</option>"+
				    "</select></br>");
			body.append("<button type='submit' class='btn btn-default'>Submit</button></form>");
		}		
				
		super.doGet(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Person p = new Person();
		p.setFname(request.getParameter("firstname"));
		p.setMname(request.getParameter("middlename"));
		p.setLname(request.getParameter("lastname"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {		
			
			Date d = sdf.parse(request.getParameter("dob"));
			java.sql.Date sqlDate = new java.sql.Date(d.getTime());
			p.setDOB(sqlDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		p.setGender(request.getParameter("gender"));
		p.setSSN(request.getParameter("ssn"));
		
//		p.setAddress1(request.getParameter("address1"));
//		p.setAddress2(request.getParameter("address2"));
//		p.setCity(request.getParameter("city"));
//		p.setState(request.getParameter("state"));
//		p.setZipcode(request.getParameter("zipcode"));
//		p.setAddressType(request.getParameter("addressType"));
//		p.setPhoneNumber(request.getParameter("phone"));
//		p.setPhoneNumberType(request.getParameter("phoneType"));
//		p.setEmail(request.getParameter("email"));
//		p.setEmailType(request.getParameter("emailtype"));
		p.setType(request.getParameter("personType"));

		
		UnicornPhoenixDB db = new UnicornPhoenixDB();
		db.addPerson(p);
	}

}
