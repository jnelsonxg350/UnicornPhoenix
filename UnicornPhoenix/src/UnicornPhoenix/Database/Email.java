package UnicornPhoenix.Database;

public class Email {
	private String Email;
	private String Type;
	private int EmailID;
	private int PersonID;
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getEmailID() {
		return EmailID;
	}
	public void setEmailID(int emailID) {
		EmailID = emailID;
	}
	public int getPersonID() {
		return PersonID;
	}
	public void setPersonID(int personID) {
		PersonID = personID;
	}

}