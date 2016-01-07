package UnicornPhoenix.Servlets;

import java.io.IOException;

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
		//display the form
		body.append("<form id='personForm'>");
		body.append("<div class='form-group'><label for='firstname'>First Name</label><input type='text' class='form-control' id='firstname' name='firstname' placeholder='First Name' value='" + p.getFirstName() + "'></div>");
		body.append("<div class='form-group'><label for='firstname'>Last Name</label><input type='text' class='form-control' id='lastname' name='lastname' placeholder='Last Name' value='" + p.getLastName() + "'></div>");
		body.append("<div class='form-group'><label for='email'>Email Address</label><input type='email' class='form-control' id='email' name='email' placeholder='Email' value='" + p.getEmailAddress() + "'></div>");
		body.append("<button type='submit' class='btn btn-default'>Submit</button></form>");
				
		super.doGet(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Person p = new Person();
		p.setFirstName(request.getParameter("firstname"));
		p.setLastName(request.getParameter("lastname"));
		p.setEmailAddress(request.getParameter("email"));
		
		UnicornPhoenixDB db = new UnicornPhoenixDB();
		db.addPerson(p);
	}

}
