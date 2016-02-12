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
			body.append("<div ><img class='center-block' src='http://images.cooltext.com/4590117.png'><h2>Please Enter The Following Inforamtion:</h2>");
			body.append("<div class='form-group'><label for='firstname'>First Name</label><input type='text' class='form-control' id='firstname' name='firstname' placeholder='First Name' required></div>");
			body.append("<div class='form-group'><label  for='middlename'>Middle Name</label><input type='text' class='form-control' id='middleName' placeholder='Middle Name' name='middlename' ></div>");
			body.append("<div class='form-group'><label for='lastname'>Last Name</label><input type='text' class='form-control' id='lastname' name='lastname' placeholder='Last Name' required></div>");
			body.append("<div class='form-group'><label for='dob'>Birth Date: </label><input type='date' class='form-control' id='dob' name='dob' required></div></br>");
			body.append("<div class='form-group'><label for='ssn'>Soical Security Number: </label><input type='number'data-inputmask=''mask': '999-99-9999'' class='form-control' id='ssn' name='ssn' placeholder='SSN' required></div></br>");
			body.append("<div class='form-group'><label for='gender'>Gender:</label><input class='female' type='radio' value='f' name='gender' required> Female <input class='male' type='radio'  value='m' name='gender' required> Male <input class='othergender' type='radio' value='o'  name='gender' required> Other </div>");
			body.append("<div class='form-group'><label for='personType'>Select one:</label><input type='radio' value='doctor' name='personType' required> Doctor <input type='radio' value='patient' name='personType' required> Paitent <input type='radio' value='provider' name='personType' required> Provider </div>");
			
			
			
			
			
			
			body.append("<button type='submit' class='btn btn-default'>Submit</button></form>");
		}
		else //found a person display their info
		{
			body.append("<form id='personForm' data-toggle='validator'>");
			body.append("<div ><img class='center-block' src='http://images.cooltext.com/4590117.png'><h2>Please Update The Following Inforamtion:</h2>");
			body.append("<input type='hidden' value='" + p.getPersonID() + "' name='id'/>");
			body.append("<div class='form-group'><label for='firstname'>First Name</label><input type='text' class='form-control' id='firstname' name='firstname' placeholder='First Name' value='" + p.getFname() + "' required></div>");
			body.append("<div class='form-group'><label for='middlename'>Middle Name</label><input type='text' class='form-control' id='middleName' placeholder='Middle Name' value='"+p.getMname()+"' name='middlename' ></div>");
			body.append("<div class='form-group'><label for='lastname'>Last Name</label><input type='text' class='form-control' id='lastname' name='lastname' placeholder='Last Name' value='" + p.getLname() + "' required></div>");
			body.append("<div class='form-group'><label for='dob'>Birth Date: </label><input type='date' class='form-control' id='dob' value='" + p.getDOB().toString() + "' name='dob' required></div></br>");
			body.append("<div class='form-group'><label for='ssn'>Socail Security Number: </label><input type='number'data-minlength='9' data-maxlength='9' class='form-control' id='ssn' name='ssn' placeholder='SSN' value='" + p.getSSN().toString() + "' required></div></br>");
//having issues getting these to show on edit i need help with this
			if (p.getGender().equalsIgnoreCase("f")){
				body.append("<div class='form-group'><label for='gender'>Gender:</label><input type='radio' value='f' name='gender' checked='checked'required>Female<input type='radio' value='m' name='gender'required>Male<input type='radio' value='o' name='gender'required>Other</div>");
			}
			else if (p.getGender().equalsIgnoreCase("m")){
				body.append("<div class='form-group'><label for='gender'>Gender:</label><input type='radio' value='f' name='gender'required>Female<input type='radio' value='m' name='gender' checked='checked'required>Male<input type='radio' value='o' name='gender'required>Other</div>");
			}
			else if (p.getGender().equalsIgnoreCase("o")){
				body.append("<div class='form-group'><label for='gender'>Gender:</label><input type='radio' value='f' name='gender'required>Female<input type='radio' value='m' name='gender'required>Male<input type='radio' value='o' name='gender' checked='checked'required>Other</div>");
			}
			if (p.getType().equalsIgnoreCase("doctor")){
				body.append("<div class='form-group'><label for='personType'>Select one:</label><input type='radio' value='doctor' name='personType' checked='checked' required> Doctor <input type='radio' value='patient' name='personType' required> Patient <input type='radio' value='provider' name='personType'required> Provider </div>");
			}
			else if(p.getType().equalsIgnoreCase("patient")){
				body.append("<div class='form-group'><label for='personType'>Select one:</label><input type='radio' value='doctor' name='personType' required> Doctor <input type='radio' value='patient' name='personType' checked='checked' required> Patient <input type='radio' value='provider' name='personType'required> Provider </div>");
			}
			else if (p.getType().equalsIgnoreCase("provider")){
				body.append("<div class='form-group'><label for='personType'>Select one:</label><input type='radio' value='doctor' name='personType' required> Doctor <input type='radio' value='patient' name='personType' required> Patient <input type='radio' value='provider' name='personType' checked='checked'required> Provider </div>");
			}
			
			body.append("<button type='submit' class='btn btn-default'>Submit</button></form>");
		}		
				
		super.doGet(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Person p = new Person();
		String firstName = request.getParameter("firstname");
		if(firstName.isEmpty())
		{
			response.sendError(500);
		}
		p.setFname(firstName);
		
		p.setMname(request.getParameter("middlename"));
		p.setLname(request.getParameter("lastname"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {		
			
			Date d = sdf.parse(request.getParameter("dob"));
			java.sql.Date sqlDate = new java.sql.Date(d.getTime());
			p.setDOB(sqlDate);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		p.setGender(request.getParameter("gender"));
		String ssn = request.getParameter("ssn");
		if(!ssn.isEmpty())
		{
			ssn = ssn.replace("-", "");
		}
		p.setSSN(ssn);
		
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