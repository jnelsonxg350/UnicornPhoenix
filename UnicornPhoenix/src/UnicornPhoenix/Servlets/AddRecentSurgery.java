package UnicornPhoenix.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddRecentSurgery
 */
@WebServlet("/AddRecentSurgery")
public class AddRecentSurgery extends Master {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRecentSurgery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		body.append("<div class='form-group'>"
				+ "<label for='surgerys'>please list any recent surgerys with commas between each:</label><input type='text' class='form-control' id='surgery'placeholder='type None for no recent surgerys'name='surgerys'></div>");

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
