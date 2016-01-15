package UnicornPhoenix.Database;

public class PhoneNumber {
   private String Pnumber;
   private String Type;
   private int PhoneNumberID;
   private int PersonID;
   
   public String getPnumber() {
		return Pnumber;
	}
	public void setPnumber(String Pnumber ) {
		this.Pnumber = Pnumber ;}
	public String getType() {
		return Type;
	}
	public void setType(String Type ) {
		this.Type =Type ;}
   public int getPhoneNumberID() {
		return PhoneNumberID;
	}
	public void setPhoneNumberID (int PhoneNumberID ) {
		this.PhoneNumberID =PhoneNumberID ;}
	
	public int getPersonID() {
		return PersonID;
	}
	public void setPersonID(int PersonID ) {
		this.PersonID = PersonID ;}
}