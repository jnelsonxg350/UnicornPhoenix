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
		body.append("<h1 style='text-align:center;' class='titlecolor'>Personal information</h1>");
		body.append("<div class='row'><div class='col-md-6'>");
		body.append("<h4><span class='titlecolortoo'>First Name:</span><span class='textcolor'>&nbsp&nbsp " + p.getFname()+"</span></br></br>");
		body.append("<span class='titlecolortoo'>Middle Name:</span><span class='textcolor'>&nbsp&nbsp "+p.getMname()+"</span></br></br>");
		body.append("<span class='titlecolortoo'>Last Name:</span><span class='textcolor'>&nbsp&nbsp "+p.getLname()+"</span></br></br>");
		body.append("<span class='titlecolortoo'>Date of Birth:</span><span class='textcolor'>&nbsp&nbsp"+p.getDOB()+"</span></br></br>");
		body.append("<span class='titlecolortoo'>SSN:</span><span class='textcolor'>&nbsp&nbsp&nbsp "+p.getSSN()+"</span></br></br>");
		if (p.getGender().toLowerCase().equals("f")){
			body.append("<span class='titlecolortoo'>Gender:</span><span class='textcolor'>&nbsp&nbsp  Female </span></br></br>");
		}
		else if (p.getGender().toLowerCase().equals("m")){
			body.append("<span class='titlecolortoo'>Gender:</span><span class='textcolor'>&nbsp&nbsp Male</span> </br></br>");
		}
		else if (p.getGender().toLowerCase().equals("o")){
			body.append("<span class='titlecolortoo'>Gender:</span><span class='textcolor'>&nbsp&nbsp Other</span> </br></br>");
		}
		if (p.getType().toLowerCase().equals("doctor")){
			body.append("<span class='titlecolortoo'>Person is a:</span><span class='textcolor'>&nbsp&nbsp Doctor</span> </br></br>");
		}
	 if(p.getType().toLowerCase().equals("patient")){
			body.append("<span class='titlecolortoo'>Person is a:</span><span class='textcolor'>&nbsp&nbsp Patient </span></br></br>");
		}
	if (p.getGender().toLowerCase().equals("provider")){
			body.append("<span class='titlecolortoo'>Person is a:</span><span class='textcolor'>&nbsp&nbsp Provider</span> </br></br>");
		}
	
		//Email
	body.append("<h3 class='titlecolor'>Email:</h3>");
		for(int i = 0;i<Emails.size();i++)
		{
		body.append("<h4 class='textcolor'>Email: "+Emails.get(i).getEmail()+"</br>");
		if (Emails.get(i).getType().toLowerCase().equals("personal")){
			body.append("Email is: Personal ");
		}
		if(Emails.get(i).getType().toLowerCase().equals("work")){
			body.append("Email is: Work ");
		}
		if(Emails.get(i).getType().toLowerCase().equals("other")){
			body.append("Email is: Other ");
		}
		body.append("</h4><button type='button' class='btn btn-default btn-xs btnUpdateEmail' data-emailid='" + Emails.get(i).getEmailID() + "'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></button>&nbsp");
		body.append("<button type='button' class='btn btn-primary btn-xs btnDeleteEmail' data-emailid='" + Emails.get(i).getEmailID() + "'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span></button></br></br>");
		}
		
		
		//add email button 
		body.append("<button type='button' class='btn btn-default btn-xs' id='addEmail' data-id='" + p.getPersonID() + "'><span class='glyphicon glyphicon-plus' aria-hidden='true'></span>&nbsp Email</button></div>");
			body.append("<div class='row'><div class='col-md-6'>");
		body.append("<h3 class='titlecolor'>Allergies</h3><h4 class='textcolor'>");
		for(int i = 0;i<allergies.size();i++)
		{
			body.append(allergies.get(i).getName()+"&nbsp&nbsp");
			body.append("<button type='button' class='btn btn-default btn-xs btnUpdateAllergy' data-allergyid='" + allergies.get(i).getAllergyID() + "'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></button>&nbsp");
			body.append("<button type='button' class='btn btn-primary btn-xs btnDeleteAllergy' data-allergyid='" + allergies.get(i).getAllergyID() + "'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span></button></br></br>");
		
		}
		//button wont work
		body.append("<button type='button' class='btn btn-default btn-xs' id='addAllergy' data-id='" + p.getPersonID() + "'><span class='glyphicon glyphicon-plus' aria-hidden='true'></span>&nbsp Allergy</button>");
		
		//Medical History info update and delete button
		body.append("<h3 class='titlecolor'>Medical History</h3><h4>");
		for(int i = 0;i<MedicalHistorys.size();i++)
		{
			body.append("<span class='textcolor'>Blood Type: "+MedicalHistorys.get(i).getBloodType() + ", &nbsp" + 
					"Weight: "+MedicalHistorys.get(i).getCurrentWeight()+ ", &nbsp" +  
					"Height: "+MedicalHistorys.get(i).getCurrentHeight() + "</span> ");
			body.append("<button type='button' class='btn btn-default btn-xs btnUpdateMedicalHistory' data-medicalhistoryid='" + MedicalHistorys.get(i).getMedicalHistoryID() + "'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></button>&nbsp");
			body.append("<button type='button' class='btn btn-primary btn-xs btnDeleteMedicalHistory' data-medicalhistoryid='" + MedicalHistorys.get(i).getMedicalHistoryID() + "'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span></button></br></br>");
		}
		
		//add medical history button 
		body.append("<button type='button' class='btn btn-default btn-xs' id='addMedHistory' data-id='" + p.getPersonID() + "'><span class='glyphicon glyphicon-plus' aria-hidden='true'></span>&nbsp Medical History</button>");
		
		//Visit
		body.append("<h3 class='titlecolor'>Visit</h3><h4 class='textcolor'>");
		for(int i = 0;i<Visits.size();i++)
		{
			body.append("Date of Visit:  "+Visits.get(i).getDateOfVisit()+"</br>");
			body.append("Blood Pressure: " +Visits.get(i).getBloodPressure() +  ", &nbsp" + 
					"Weight: " +Visits.get(i).getWeight() +  ", &nbsp" +  
					"Height: " +Visits.get(i).getHeight() +"</br>");
			body.append("Visit: "+Visits.get(i).getType()+"</br>");
			if (Visits.get(i).getType().toLowerCase().equals("Walk-In")){
			}
			if(Visits.get(i).getType().toLowerCase().equals("Check-Up")){
			}
			if(Visits.get(i).getType().toLowerCase().equals("Emergency")){
			}
			body.append("Result: "+Visits.get(i).getResult()+"</br></br>");
			body.append("<button type='button' class='btn btn-default btn-xs btnUpdateVisit' data-visitid='" + Visits.get(i).getVisitID() + "'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></button>&nbsp");
			body.append("<button type='button' class='btn btn-primary btn-xs btnDeleteVisit' data-visitid='" + Visits.get(i).getVisitID() + "'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span></button></br></br>");
		}
		
		//add visit button 
		body.append("<button type='button' class='btn btn-default btn-xs' id='addVisit' data-id='" + p.getPersonID() + "'><span class='glyphicon glyphicon-plus' aria-hidden='true'></span>&nbsp Visit</button>");
		
		super.doGet(request, response);
	}

}
