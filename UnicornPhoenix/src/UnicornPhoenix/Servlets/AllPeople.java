package UnicornPhoenix.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UnicornPhoenix.Database.*;
@WebServlet("/AllPeople")
public class AllPeople extends Master {	
	private static final long serialVersionUID = 1L;
	public AllPeople() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//add content
    	body.append("<h1 style='text-align:center;' class='titlecolor'><span class='glyphicon glyphicon-user' aria-hidden='true'></span>&nbsp People</h1>");
		
    	//start the table
    	body.append("<table class='table'><caption><button type='button' class='btn btn-default btnAddPerson'>Add Person</button></caption><thead><tr><th></th><th class='titlecolor'>First Name</th><th class='titlecolor'>Last Name</th><th class='titlecolor'>Type</th></tr></thead>");
    	body.append("<tbody>");	
    	
    	////add the people
    	UnicornPhoenixDB db = new UnicornPhoenixDB();
    	ArrayList<Person> people = db.getPeople();
    	for(int i = 0;i<people.size();i++)
    	{
    		Person p = people.get(i);
        	body.append("<tr><td><button type='button' class='btn btn-primary btn-xs btnEditPerson' data-id='" + p.getPersonID() + "'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span> </button><button type='button' class='btn btn-primary btn-xs btnDeletePerson' data-id='" + p.getPersonID() + "'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span></button>&nbsp<button type='button' class='btn btn-primary btn-xs btnPersonDetails' data-id='" + p.getPersonID() + "'> <span class='glyphicon glyphicon-info-sign' aria-hidden='true'></span> </button></td><td class='textcolor'>" + p.getFname() + "</td><td class='textcolor'>" + p.getLname() + "</td><td class='textcolor'>" + p.getType() + "</td></tr>");
    	}
    	
    	//close the table
    	body.append("</tbody></table>");
    	//call the super method
		super.doGet(request, response);
	}

}
