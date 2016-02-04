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

import UnicornPhoenix.Database.Person;
import UnicornPhoenix.Database.PhoneNumber;
import UnicornPhoenix.Database.UnicornPhoenixDB;

/**
 * Servlet implementation class AddPhoneNumber
 */
@WebServlet("/AddPhoneNumber")
public class AddPhoneNumber extends Master {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPhoneNumber() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		body.append("<div class='form-inline'><label for='phone'>Phone Number</label><input type='tel' class='form-control' id='phoneNumber' size='10' placeholder='(xxx)xxx-xxxx'></div></br>");
	body.append("<div class='form-group'>"+
			    "<label for='phonetype'>Phone Type:  </label>"+
			   
			    "<input type='radio' id='phonehome'name='home' value='home'>Home"+
			 
			    "<input type='radio' id='phonework' name='work'value='work'>Work"+
			   
			    "<input type='radio' id='phonemobile' name='mobile' value='mobile'>Mobile "+
			    "<input type='radio' id='phoneother' name='other' value='other'>Other</div></br>");
	body.append("<div class='form-group'>"+
	    		"<button type='submit' class='btn btn-default'>Submit</button></div></form>");
		super.doGet(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PhoneNumber pn = new PhoneNumber();
        Integer phoneNumberID=0;
		try {
			phoneNumberID=Integer.parseInt(request.getParameter("PhoneNumberNumberID"));
		}
     catch (Exception e) {}
		pn.setPhoneNumberID(phoneNumberID);
				pn.setPersonID(request.getParameter("PersonID"));
				pn.setPhoneNumberID(request.getParameter("PhoneNumberID"));
				
				
				pn.setType(request.getParameter("personType"));

				
				UnicornPhoenixDB db = new UnicornPhoenixDB();
				if(request.getParameter("id") != null)
				{
					int id = Integer.parseInt(request.getParameter("id") );
					pn.setPhoneNumberID(id);
				db.updatePhoneNumber(pn);
			}
			else
			{
				db.addPhoneNumber(pn);
			}
			}
}


