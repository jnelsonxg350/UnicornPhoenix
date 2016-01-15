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
			//body.append("<div class='form-group'><label for='gender'>Gender:  </label><label class='checkbox-inline'><input type='checkbox' id='genderCheckbox1' value='female'>Female </label><label class='checkbox-inline'><input type='checkbox' id='genderCheckbox2' value='male'>Male </label></div>");
//			body.append("<div class='form-group'><label for='address1'>Address line 1</label><input type='text' class='form-control' id='address1' placeholder='Address'></div>");
//			body.append("<div class='form-group'><label for='address2'>Address line 2</label><input type='text' class='form-control' id='address2' placeholder='(Optional)'></div>");
//			body.append("<div class='form-inline'><label for='city'>City </label><input type='text' class='form-control' id='city' placeholder='City'></div></br><div class='form-inline'>");
//			body.append("<div class='form-inline'>"+
//				    "<select id='Select' class='form-control'>"+
//				    "<option value='al'>AL</option>"+
//				    "<option value='ak'>AK</option>"+
//				    "<option value='az'>AZ</option>"+
//				    "<option value='ar'>AR</option>"+
//				    "<option vlaue='ca'>CA</option>"+
//				    "<option value='co'>CO</option>"+
//				    "<option vlaue='ct'>CT</option>"+
//				    "<option value='de'>DE </option>"+
//				    "<option value='fl'>FL</option>"+
//				    "<option value='ga'>GA</option>"+
//				    "<option value='hi'>HI</option>"+
//				    "<option value='id'>ID </option>"+
//				    "<option value='il'>IL</option>"+
//				    "<option value='in'>IN </option>"+
//				    "<option value='ia'>IA</option>"+
//				    "<option value='ks'>KS</option> "+
//				    "<option value='ky'>KY</option> "+
//				    "<option value='la'>LA</option> "+
//				    "<option value='me'>ME</option>"+
//				    "<option value='md'>MD</option> "+
//				    "<option value='ma'>MA</option> "+
//				    "<option value='mi'>MI</option> "+
//				    "<option value='mn'>MN</option> "+
//				    "<option value='ms'>MS</option> "+
//				    "<option value='mo'>MO</option> "+
//				    "<option value='mt'>MT</option> "+
//				    "<option value='ne'>NE</option> "+
//				    "<option value='nv'>NV</option> "+
//				    "<option value='nh'>NH</option> "+
//				    "<option value='nj'>NJ</option> "+
//				    "<option value='nm'>NM</option> "+
//				    "<option value='ny'>NY</option> "+
//				    "<option value='nc'>NC</option> "+
//				    "<option value='nd'>ND</option> "+
//				    "<option value='oh'>OH</option> "+
//				    "<option value='ok'>OK</option> "+
//					"<option value='or'>OR</option> "+
//					"<option value='pa'>PA</option> "+
//					"<option value='ri'>RI</option> "+
//					"<option value='sc'>SC</option> "+
//					"<option value='ds'>SD</option> "+
//					"<option value='tn'>TN</option> "+
//					"<option value='tc'>TX</option> "+
//					"<option value='ut'>UT</option> "+
//					"<option value='vt'>VT</option> "+
//					"<option value='va'>VA</option> "+
//					"<option value='wa'>WA</option> "+
//					"<option value='wv'>WV</option> "+
//					"<option value='wi'>WI</option> "+
//					"<option value='wy'>WY</option>"+
//					"</select></div></br>");
//			body.append("<div class='form-inline'><label for='zipCode'>ZipCode </label><input type='text' class='form-control' id='zip' placeholder='ZipCode'></br>");
//			body.append("<div class='form-group'>"+
//				    "<label for='addressType'>Address Type:  </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='addressCheckbox1' value='home'>Home </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='addressCheckbox2' value='work'>Work </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='addressCheckbox2' value='poBox'>PO Box </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='addressCheckbox2' value='other'>Other </label></div></br>");
//			body.append("<div class='form-inline'><label for='phone'>Phone Number</label><input type='tel' class='form-control' id='phoneNumber' size='10' placeholder='(xxx)xxx-xxxx'></div></br>");
//			body.append("<div class='form-group'>"+
//				    "<label for='phonetype'>Phone Type:  </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='phoneCheckbox1' value='home'>Home </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='phoneCheckbox2' value='work'>Work </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='phoneCheckbox2' value='mobile'>Mobile </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='phoneCheckbox2' value='other'>Other </label></div></br>");
//			body.append("<div class='form-group'><label for='email'>Email Address</label><input type='email' class='form-control' id='email' name='email' placeholder='Email'></div>");
//			body.append("<div class='form-group'>"+
//				    "<label for='emailtype'>Email Type:  </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='emailCheckbox1' value='personal'>Personal </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='emailCheckbox2' value='work'>Work </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='emailCheckbox2' value='other'>Other </label>");
			body.append("<div class='form-inline'>"+
				    "<label for='personType'>select one: </label>"+
				    "<select id='Select' class='form-control' name=''>"+
				    "<option value='doctor'>Doctor</option>"+
				    "<option value='paitent'>Paitent</option>"+
				    "<option value='provider'>Provider</option>"+
				    "</select></br>");
			body.append("<a href='http://localhost:8080/UnicornPhoenix/AddMedicalHistory'><button type='button' class='btn btn-info'>Go to Medical History</button></a>");
			body.append("<a href='http://localhost:8080/UnicornPhoenix/AddBillingInfo'><button type='button' class='btn btn-info'>Go to Billing information</button></a>");

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
//			body.append("<div class='form-group'><label for='address1'>Address line 1</label><input type='text' class='form-control' id='address1' placeholder='Address' value='"p.getAddress1()+"'></div>");
//			body.append("<div class='form-group'><label for='address2'>Address line 2</label><input type='text' class='form-control' id='address2' placeholder='(Optional)' value='"p.getAddress2()+"'></div>");
//			body.append("<div class='form-inline'><label for='city'>City </label><input type='text' class='form-control' id='city' placeholder='City' value='"p.getCity()+"'></div></br><div class='form-inline'>");
//			body.append("<div class='form-inline'>"+
//				    "<label for='state'>State </label>"+
//				    "<select id='Select' class='form-control' value='"p.getState()+"'>"+
//				    "<option value='al'>AL</option>"+
//				    "<option value='ak'>AK</option>"+
//				    "<option value='az'>AZ</option>"+
//				    "<option value='ar'>AR</option>"+
//				    "<option vlaue='ca'>CA</option>"+
//				    "<option value='co'>CO</option>"+
//				    "<option vlaue='ct'>CT</option>"+
//				    "<option value='de'>DE </option>"+
//				    "<option value='fl'>FL</option>"+
//				    "<option value='ga'>GA</option>"+
//				    "<option value='hi'>HI</option>"+
//				    "<option value='id'>ID </option>"+
//				    "<option value='il'>IL</option>"+
//				    "<option value='in'>IN </option>"+
//				    "<option value='ia'>IA</option>"+
//				    "<option value='ks'>KS</option> "+
//				    "<option value='ky'>KY</option> "+
//				    "<option value='la'>LA</option> "+
//				    "<option value='me'>ME</option>"+
//				    "<option value='md'>MD</option> "+
//				    "<option value='ma'>MA</option> "+
//				    "<option value='mi'>MI</option> "+
//				    "<option value='mn'>MN</option> "+
//				    "<option value='ms'>MS</option> "+
//				    "<option value='mo'>MO</option> "+
//				    "<option value='mt'>MT</option> "+
//				    "<option value='ne'>NE</option> "+
//				    "<option value='nv'>NV</option> "+
//				    "<option value='nh'>NH</option> "+
//				    "<option value='nj'>NJ</option> "+
//				    "<option value='nm'>NM</option> "+
//				    "<option value='ny'>NY</option> "+
//				    "<option value='nc'>NC</option> "+
//				    "<option value='nd'>ND</option> "+
//				    "<option value='oh'>OH</option> "+
//				    "<option value='ok'>OK</option> "+
//					"<option value='or'>OR</option> "+
//					"<option value='pa'>PA</option> "+
//					"<option value='ri'>RI</option> "+
//					"<option value='sc'>SC</option> "+
//					"<option value='ds'>SD</option> "+
//					"<option value='tn'>TN</option> "+
//					"<option value='tc'>TX</option> "+
//					"<option value='ut'>UT</option> "+
//					"<option value='vt'>VT</option> "+
//					"<option value='va'>VA</option> "+
//					"<option value='wa'>WA</option> "+
//					"<option value='wv'>WV</option> "+
//					"<option value='wi'>WI</option> "+
//					"<option value='wy'>WY</option>"+
//					"</select></div></br>");
//			body.append("<div class='form-inline'><label for='zipCode'>ZipCode </label><input type='text' class='form-control' id='zip' placeholder='ZipCode' value='"p.getZipcode()+"'></br>");
//			body.append("<div class='form-group'>"+
//				    "<label for='addressType'>Address Type:  </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='addressCheckbox1' value='home'>Home </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='addressCheckbox2' value='work'>Work </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='addressCheckbox2' value='poBox'>PO Box </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='addressCheckbox2' value='other'>Other </label></div></br>");
//			body.append("<div class='form-inline'><label for='phone'>Phone Number</label><input type='tel' class='form-control' id='phoneNumber' size='10' placeholder='(xxx)xxx-xxxx' value='"p.getPhoneNumber()+"'></div></br>");
//			body.append("<div class='form-group'>"+
//				    "<label for='phonetype'>Phone Type:  </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='phoneCheckbox1' value='home'>Home </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='phoneCheckbox2' value='work'>Work </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='phoneCheckbox2' value='mobile'>Mobile </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='phoneCheckbox2' value='other'>Other </label></div></br>");
//			body.append("<div class='form-group'><label for='email'>Email Address</label><input type='email' class='form-control' id='email' name='email' placeholder='Email' value='"p.getEmailAddress()+"'></div>");
//			body.append("<div class='form-group'>"+
//				    "<label for='emailtype'>Email Type:  </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='emailCheckbox1' value='personal'>Personal </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='emailCheckbox2' value='work'>Work </label>"+
//				    "<label class='checkbox-inline'>"+
//				    "<input type='checkbox' id='emailCheckbox2' value='other'>Other </label>");
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
