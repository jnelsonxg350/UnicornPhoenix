package UnicornPhoenix.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		body.append("<div class='form-group'><label for='email'>Email Address</label><input type='email' class='form-control' id='email' name='email' placeholder='Email'></div>");
		body.append("<div class='form-group'>"+
			    "<label for='emailtype'>Email Type:  </label>"+
			 
			    "<input type='radio' id='emailpersonal' value='personal'name='emailpersonal'>Personal"+
			   
			    "<input type='radio' id='emailwork' value='work'name='emailwork'>Work"+
			
			    "<input type='radio' id='emailother' value='other'name='emailother'>Other");
		body.append("<button type='submit' class='btn btn-default'>Submit</button></form>");		
			
	super.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
