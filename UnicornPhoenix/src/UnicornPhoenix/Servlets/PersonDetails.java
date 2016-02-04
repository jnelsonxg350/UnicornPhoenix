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
		body.append("<h4>First Name: " + p.getFname()+"</br></br>");
		body.append("Middle Name: "+p.getMname()+"</br></br>");
		body.append("Last Name: "+p.getLname()+"</br></br>");
		body.append("Date of Birth:"+p.getDOB()+"</br></br>");
		body.append("SSN: "+p.getSSN());
		//these dont show
		if (p.getGender()=="F"){
			body.append("Gender: Female </br></br>");
		}
		else if (p.getGender()=="M"){
			body.append("Gender: Male </br></br>");
		}
		else if (p.getGender()=="O"){
			body.append("Gender: Other </br></br>");
		}
		if (p.getType()=="doctor"){
			body.append("Person is a: Doctor </br></br>");
		}
	 if(p.getType()=="patient"){
			body.append("Person is a: Patient </br></br>");
		}
	if (p.getGender()=="provider"){
			body.append("Person is a: Provider </br></br>");
		}
		
		body.append("<h3>Allergies<h3>");
		for(int i = 0;i<allergies.size();i++)
		{
			body.append(allergies.get(i).getName() + "<br/>");
		}
		//button wont work
		body.append("<button type='button' class='btn btn-default' btn-xs btnUpdateAllergy>Add Allergy</button>");
		
		super.doGet(request, response);
	}

}
