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
			body.append("<form id='personForm' data-toggle='validator'>");
			body.append("<div class='form-group'><label for='firstname'>First Name</label><input type='text' class='form-control' id='firstname' name='firstname' placeholder='First Name' required></div>");
			body.append("<div class='form-group'><label for='middlename'>Middle Name</label><input type='text' class='form-control' id='middleName' placeholder='Middle Name' name='middlename' required></div>");
			body.append("<div class='form-group'><label for='lastname'>Last Name</label><input type='text' class='form-control' id='lastname' name='lastname' placeholder='Last Name' required></div>");
			body.append("<div class='form-inline'><label for='dob'>Birth Date:</label><input type='date' class='form-control' id='dob' name='dob' required></div>");
			body.append("<div class='form-group'><label for='ssn'>SSN</label><input type='text' class='form-control' id='ssn' name='ssn' placeholder='SSN' required></div>");
			body.append("<div class='form-group'><label for='gender'>Gender:</label><input type='radio' value='f' name='gender' required> Female <input type='radio' value='m' name='gender' required> Male <input type='radio' value='o' name='gender' required> Other </div>");
			body.append("<div class='form-group'><label for='personType'>Select one:</label><input type='radio' value='doctor' name='personType' required> Doctor <input type='radio' value='patient' name='personType' required> Paitent <input type='radio' value='provider' name='personType' required> Provider </div>");
			
			
			
			
			
			
			body.append("<button type='submit' class='btn btn-default'>Submit</button></form>");
		}
		else //found a person display their info
		{
			body.append("<form id='personForm' data-toggle='validator'>");
			body.append("<input type='hidden' value='" + p.getPersonID() + "' name='id'/>");
			body.append("<div class='form-group'><label for='firstname'>First Name</label><input type='text' class='form-control' id='firstname' name='firstname' placeholder='First Name' value='" + p.getFname() + "' required></div>");
			body.append("<div class='form-group'><label for='middlename'>Middle Name</label><input type='text' class='form-control' id='middleName' placeholder='Middle Name' value='"+p.getMname()+"' name='middlename' required></div>");
			body.append("<div class='form-group'><label for='lastname'>Last Name</label><input type='text' class='form-control' id='lastname' name='lastname' placeholder='Last Name' value='" + p.getLname() + "' required></div>");
			body.append("<div class='form-inline'><label for='dob'>Birth Date:</label><input type='date' class='form-control' id='dob' value='" + p.getDOB().toString() + "' name='dob' required></div>");
			body.append("<div class='form-group'><label for='ssn'>SSN</label><input type='text' class='form-control' id='ssn' name='ssn' placeholder='SSN' value='" + p.getSSN().toString() + "' required></div>");
			if(p.getGender().equals("f")){
				body.append("<div class='form-group'><label for='gender'>Gender:</label><input type='radio' value='f' name='gender' checked='checked' required>Female<input type='radio' value='m' name='gender' required>Male<input type='radio' value='o' name='gender' required>Other</div>");
			}
			if(p.getGender().equals("m")){
				body.append("<div class='form-group'><label for='gender'>Gender:</label><input type='radio' value='f' name='gender' required>Female<input type='radio' value='m' name='gender' checked='checked' required>Male<input type='radio' value='o' name='gender' required>Other</div>");
			}
			if(p.getGender().equals("o")){
				body.append("<div class='form-group'><label for='gender'>Gender:</label><input type='radio' value='f' name='gender'required>Female<input type='radio' value='m' name='gender' required>Male<input type='radio' value='o' name='gender' checked='checked' required>Other</div>");
			}
			
			
			if(p.getType().equals("doctor")){
				body.append("<div class='form-group'><label for='personType'>Select one:</label><input type='radio' value='doctor' name='personType' checked='checked' required>Doctor<input type='radio' value='patient' name='personType' required>Paitent<input type='radio' value='provider' name='personType' required>Provider</div>");
			}
			if(p.getType().equals("patient")){
				body.append("<div class='form-group'><label for='personType'>Select one:</label><input type='radio' value='doctor' name='personType' required>Doctor<input type='radio' value='patient' name='personType' checked='checked' required>Paitent<input type='radio' value='provider' name='personType' required>Provider</div>");
			}
			if(p.getType().equals("provider")){
				body.append("<div class='form-group'><label for='personType'>Select one:</label><input type='radio' value='doctor' name='personType' required>Doctor<input type='radio' value='patient' name='personType' required>Paitent<input type='radio' value='provider' name='personType' checked='checked' required>Provider</div>");
			}
			
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
		
		p.setType(request.getParameter("personType"));

		
		UnicornPhoenixDB db = new UnicornPhoenixDB();
		if(request.getParameter("id") != null)
		{
			int id = Integer.parseInt(request.getParameter("id") );
			p.setPersonID(id);
			db.updatePerson(p);
		}
		else
		{
			db.addPerson(p);
		}
	}

}
