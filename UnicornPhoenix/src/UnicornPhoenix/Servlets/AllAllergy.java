package UnicornPhoenix.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UnicornPhoenix.Database.Allergy;
import UnicornPhoenix.Database.UnicornPhoenixDB;

@WebServlet("/AllAllergy")
public class AllAllergy extends Master {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllAllergy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		body.append("<h1>Allergies</h1>");
		
    	//start the table
    	body.append("<table class='table'><caption><button type='button' class='btn btn-default btnAddAllergy'>Add Allergy</button></caption><thead><tr><th></th><th>Allergy:</th></tr></thead>");
    	body.append("<tbody>");	
    	
    	////add the allergies
    	UnicornPhoenixDB db = new UnicornPhoenixDB();
    	ArrayList<Allergy> allergy = db.getAllergies();
    	for(int i = 0;i<allergy.size();i++)
    	{
    		Allergy p = allergy.get(i);
        	body.append("<tr><td><button type='button' class='btn btn-primary btn-xs btnEditPerson' data-id='" + p.getAllergyID() + "'>Edit</button><button type='button' class='btn btn-primary btn-xs btnDeletePerson' data-id='" + p.getAllergyID() + "'>Delete</button></td><td>" + p.getName() + "</td></tr>");
    	}
    	
    	//close the table
    	body.append("</tbody></table>");
   
	
	
	
	
	
	
	
	
		super.doGet(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
