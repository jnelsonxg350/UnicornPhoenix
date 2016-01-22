package UnicornPhoenix.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UnicornPhoenix.Database.Allergy;
import UnicornPhoenix.Database.Person;
import UnicornPhoenix.Database.UnicornPhoenixDB;

/**
 * Servlet implementation class AddAllergy
 */
@WebServlet("/AddAllergy")
public class AddAllergy extends Master {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAllergy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		body.append( "<form id=addAllergy>");
		body.append("<div class='form-group'>"+
				 "<label for='allergies'>Please list allergys with commas between each:</label><input type='text' class='form-control' id='allergies' placeholder='type None for no allergies' name='allergies'></div>");

		body.append("<div class='form-group'>"+
	    		"<button type='submit' class='btn btn-default'>Submit</button></div></form>");
		super.doGet(request, response);

	
	
	
	
	
	
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
