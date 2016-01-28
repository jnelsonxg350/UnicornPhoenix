package UnicornPhoenix.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UnicornPhoenix.Database.Email;
import UnicornPhoenix.Database.Person;
import UnicornPhoenix.Database.UnicornPhoenixDB;


/**
 * Servlet implementation class AddEmail
 */
@WebServlet("/AddEmail")
public class AddEmail extends Master {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UnicornPhoenixDB db = new UnicornPhoenixDB();
		Email e = db.getEmail(request.getParameter("id"));
		
		if(e.getEmail() == null)
		{
			body.append("<form id='emailForm'>");
			body.append("<div class='form-group'><label for='email'>Email Address</label><input type='email' class='form-control' id='email' name='email' placeholder='Email'></div>");
			body.append("<div class='form-group'>"+
				    "<label for='emailtype'>Email Type:  </label>"+			 
				    "<input type='radio' value='personal'name='emailtype'>Personal"+			   
				    "<input type='radio' value='work' name='emailtype'>Work"+			
				    "<input type='radio' value='other'name='emailtype'>Other</div>");		
			body.append("<button type='submit' class='btn btn-default'>Submit</button></form>");
		}
		else
		{
			body.append("<form id='emailForm'>");
			body.append("<input type='hidden' value='" + e.getEmailID() + "' name='id'/>");
			body.append("<div class='form-group'><label for='email'>Email Address</label><input type='email' class='form-control' id='email' name='email' placeholder='Email' value='" + e.getEmail() + "'></div>");
			body.append("<div class='form-group'>"+
				    "<label for='emailtype'>Email Type:  </label>"+	getSelectedEmailType(e));
			
			body.append("<button type='submit' class='btn btn-default'>Submit</button></form>");
		}
				
			
	super.doGet(request, response);
	}
	private String getSelectedEmailType(Email email)
	{
		String selectedEmail = ""; 
				
		if(email.getType().equals("personal"))
		{
			selectedEmail = "<input type='radio' value='personal'name='emailtype' checked='checked'>Personal"+			   
				            "<input type='radio' value='work' name='emailtype'>Work"+			
				            "<input type='radio' value='other'name='emailtype'>Other</div>";
		}
		else if(email.getType().equals("work"))
		{
			selectedEmail = "<input type='radio' value='personal'name='emailtype'>Personal"+			   
				            "<input type='radio' value='work' name='emailtype' checked='checked'>Work"+			
				            "<input type='radio' value='other'name='emailtype'>Other</div>";
		}
		else if(email.getType().equals("other"))
		{
			selectedEmail = "<input type='radio' value='personal'name='emailtype'>Personal"+			   
				            "<input type='radio' value='work' name='emailtype'>Work"+			
				            "<input type='radio' value='other'name='emailtype' checked='checked'>Other</div>";
		}
		
		return selectedEmail;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Email e = new Email();
		e.setEmail(request.getParameter("email"));
		e.setType(request.getParameter("emailtype"));	
		
		// TODO Attach to a person
		e.setPersonID(5);
		
		UnicornPhoenixDB db = new UnicornPhoenixDB();
		if(request.getParameter("id") != null)
		{
			int id = Integer.parseInt(request.getParameter("id"));
			e.setEmailID(id);
			System.out.println(e.toString());
			db.updateEmail(e);
		}
		else
		{
			db.addEmail(e);
		}
		
	}

}
