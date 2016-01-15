package UnicornPhoenix.Database;

public class MedicalHistory {
	private String BloodType;
	private int CurrentHeight;
	private int CurrentWeight;
	private int PersonID;
	private int MedicalHistoryID;
	public String getBloodType() {
		return BloodType;
	}
	public void setBloodType(String bloodType) {
		BloodType = bloodType;
	}
	public int getCurrentHeight() {
		return CurrentHeight;
	}
	public void setCurrentHeight(int currentHeight) {
		CurrentHeight = currentHeight;
	}
	public int getCurrentWeight() {
		return CurrentWeight;
	}
	public void setCurrentWeight(int currentWeight) {
		CurrentWeight = currentWeight;
	}
	public int getPersonID() {
		return PersonID;
	}
	public void setPersonID(int personID) {
		PersonID = personID;
	}
	public int getMedicalHistoryID() {
		return MedicalHistoryID;
	}
	public void setMedicalHistoryID(int medicalHistoryID) {
		MedicalHistoryID = medicalHistoryID;
	}
	
	

	
}