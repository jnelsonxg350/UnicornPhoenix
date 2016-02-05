package UnicornPhoenix.Database;

import java.sql.Date;

public class Visit {
	private Date dateOfVisit;
	private int Height;
	private String BloodPressure;
	private int Weight;
	private String Result;
	private String Type;
	private int PersonID;
	private int VisitID;
	public Date getDateOfVisit() {
		return dateOfVisit;
	}
	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	public int getHeight() {
		return Height;
	}
	public void setHeight(int height) {
		Height = height;
	}
	public String getBloodPressure() {
		return BloodPressure;
	}
	public void setBloodPressure(String bloodPressure) {
		BloodPressure = bloodPressure;
	}
	public int getWeight() {
		return Weight;
	}
	public void setWeight(int weight) {
		Weight = weight;
	}
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getPersonID() {
		return PersonID;
	}
	public void setPersonID(int personID) {
		PersonID = personID;
	}
	public int getVisitID() {
		return VisitID;
	}
	public void setVisitID(int visitID) {
		VisitID = visitID;
	}

	
}
