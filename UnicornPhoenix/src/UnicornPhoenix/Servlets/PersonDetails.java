package UnicornPhoenix.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UnicornPhoenix.Database.*;
@WebServlet("/PersonDetails")
public class PersonDetails extends Master {	
	private static final long serialVersionUID = 1L;
	public PersonDetails() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UnicornPhoenixDB db = new UnicornPhoenixDB();
		Person p = db.getPerson(request.getParameter("id"));
		if(p == null)
		{
			response.sendError(500);
		}
		ArrayList<Allergy> allergies = db.getAllergysForPerson(p.getPersonID());	
		
		//Print details
		body.append("Name: " + p.getFname());
		
		body.append("<h3>Allergies<h3>");
		for(int i = 0;i<allergies.size();i++)
		{
			body.append(allergies.get(i).getName() + "<br/>");
		}
		body.append("<button type='button' class='btn btn-default'>Add Allergy</button>");
		
		super.doGet(request, response);
	}

}
