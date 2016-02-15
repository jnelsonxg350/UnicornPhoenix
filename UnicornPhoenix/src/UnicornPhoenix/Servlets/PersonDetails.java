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
		ArrayList<MedicalHistory> MedicalHistorys = db.getMedicalHistorysForPerson(p.getPersonID());
		ArrayList<Email> Emails = db.getEmailsForPerson(p.getPersonID());
		ArrayList<Visit> Visits = db.getVisitsForPerson(p.getPersonID());
		
		//Print details
		body = new StringBuilder();
		body.append("<h4>First Name: " + p.getFname()+"</br></br>");
		body.append("Middle Name: "+p.getMname()+"</br></br>");
		body.append("Last Name: "+p.getLname()+"</br></br>");
		body.append("Date of Birth:"+p.getDOB()+"</br></br>");
		body.append("SSN: "+p.getSSN()+"</br></br>");
		if (p.getGender().toLowerCase().equals("f")){
			body.append("Gender: Female </br></br>");
		}
		else if (p.getGender().toLowerCase().equals("m")){
			body.append("Gender: Male </br></br>");
		}
		else if (p.getGender().toLowerCase().equals("o")){
			body.append("Gender: Other </br></br>");
		}
		if (p.getType().toLowerCase().equals("doctor")){
			body.append("Person is a: Doctor </br></br>");
		}
	 if(p.getType().toLowerCase().equals("patient")){
			body.append("Person is a: Patient </br></br>");
		}
	if (p.getGender().toLowerCase().equals("provider")){
			body.append("Person is a: Provider </br></br>");
		}
	
		//Email
		for(int i = 0;i<Emails.size();i++)
		{
		body.append("Email: "+Emails.get(i).getEmail()+"</br>");
		if (Emails.get(i).getType().toLowerCase().equals("personal")){
			body.append("Email is: Personal ");
		}
		if(Emails.get(i).getType().toLowerCase().equals("work")){
			body.append("Email is: Work ");
		}
		if(Emails.get(i).getType().toLowerCase().equals("other")){
			body.append("Email is: Other ");
		}
		body.append("<button type='button' class='btn btn-default btn-xs btnUpdateEmail' data-emailid='" + Emails.get(i).getEmailID() + "'>Edit Email</button>&nbsp");
		body.append("<button type='button' class='btn btn-primary btn-xs btnDeleteEmail' data-emailid='" + Emails.get(i).getEmailID() + "'>Delete</button></br></br>");
		}
		
		//add email button 
		body.append("<button type='button' class='btn btn-default btn-xs' id='addEmail' data-id='" + p.getPersonID() + "'>Add Email</button>");
			
		body.append("<h3>Allergies<h3>");
		for(int i = 0;i<allergies.size();i++)
		{
			body.append(allergies.get(i).getName() + "<br/>");
		}
		//button wont work
		body.append("<button type='button' class='btn btn-default btn-xs' id='btnUpdateAllergy' data-id='" + p.getPersonID() + "'>Add Allergy</button>");
		
		//Medical History info update and delete button
		body.append("<h3>Medical History<h3>");
		for(int i = 0;i<MedicalHistorys.size();i++)
		{
			body.append(MedicalHistorys.get(i).getBloodType() + "  BloodType" + "   " + 
					MedicalHistorys.get(i).getCurrentWeight() + "  Weight" + "   " +  
					MedicalHistorys.get(i).getCurrentHeight() + "  Height" + "   ");
			body.append("<button type='button' class='btn btn-default btn-xs btnUpdateMedicalHistory' data-medicalhistoryid='" + MedicalHistorys.get(i).getMedicalHistoryID() + "'>Edit Medical History</button>&nbsp");
			body.append("<button type='button' class='btn btn-primary btn-xs btnDeleteMedicalHistory' data-medicalhistoryid='" + MedicalHistorys.get(i).getMedicalHistoryID() + "'>Delete</button></br></br>");
		}
		
		//add medical history button 
		body.append("<button type='button' class='btn btn-default btn-xs' id='addMedHistory' data-id='" + p.getPersonID() + "'>Add Medical History</button>");
		
		//Visit
		body.append("<h3>Visit<h3>");
		for(int i = 0;i<Visits.size();i++)
		{
			body.append("Date of Visit:"+Visits.get(i).getDateOfVisit()+"</br></br>");
			body.append(Visits.get(i).getBloodPressure() + "  BloodPressure" + "   " + 
					Visits.get(i).getWeight() + "  Weight" + "   " +  
					Visits.get(i).getHeight() + "  Height" + "   ");
			body.append("Visit: "+Visits.get(i).getType()+"</br>");
			if (Visits.get(i).getType().toLowerCase().equals("Walk-In")){
				//body.append("Email is: Personal ");
			}
			if(Visits.get(i).getType().toLowerCase().equals("Check-Up")){
				//body.append("Email is: Work ");
			}
			if(Visits.get(i).getType().toLowerCase().equals("Emergency")){
				//body.append("Email is: Other ");
			}
			body.append("Result: "+Visits.get(i).getResult()+"</br>");
			body.append("<button type='button' class='btn btn-default btn-xs btnUpdateVisit' data-visitid='" + Visits.get(i).getVisitID() + "'>Edit Visit</button>&nbsp");
			body.append("<button type='button' class='btn btn-primary btn-xs btnDeleteVisit' data-visitid='" + Visits.get(i).getVisitID() + "'>Delete</button></br></br>");
		}
		
		//add visit button 
		body.append("<button type='button' class='btn btn-default btn-xs' id='addVisit' data-id='" + p.getPersonID() + "'>Add Visit</button>");
		
		super.doGet(request, response);
	}

}
