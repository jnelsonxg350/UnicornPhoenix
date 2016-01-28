package UnicornPhoenix.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		UnicornPhoenixDB db = new UnicornPhoenixDB();
		Allergy a = db.getAllergy(request.getParameter("allergyID"));
		body.append("<div class='form-group'>"+
				 "<label for='allergies'>Please type in an allery:</label><input type='text' class='form-control' id='allergies' placeholder='type None for no allergies' name='allergies'></div> required");
		
		body.append("<div class='form-group'>"+
	    		"<button type='submit' class='btn btn-default'>Submit</button></div></form>");
	
		}
		
		else{
			body.append( "<form id=addAllergy>");
			body.append("<input type='hidden' value='" + a.getAllergyID() + "' name='allergyID'/>");
			body.append("<input type='hidden' value='" + a.getPersonID() + "' name='id'/>");
			body.append("<div class='form-group'>"+
					 "<label for='allergies'>Please type in an allergy:</label><input type='text' class='form-control' id='allergies' placeholder='type None for no allergies' name='allergies' value="+a.getName()+"></div>");
			
			body.append("<div class='form-group'>"+
		    		"<button type='submit' class='btn btn-default'>Submit</button></div></form>");
		
		}
		
	super.doGet(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Allergy a = new Allergy();
		a.setName(request.getParameter("allergies"));
		UnicornPhoenixDB db = new UnicornPhoenixDB();
		if(request.getParameter("allergyID") != null)
		{
			int id = Integer.parseInt(request.getParameter("AllergyID") );
			a.setAllergyID(id);
			db.updateAllergy(a);
		}
		else
		{
			db.addAllergy(a);
		}
		
		
	}

}
