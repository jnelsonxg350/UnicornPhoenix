package UnicornPhoenix.Database;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Address {
	private String Address;
	private String City;
	private String State;
	private String Zip;
	private String Type;
	private int PersonID;
	private int AddressID;


public String getAddress() {
	return Address;
}
public void setAddress(String Address) {
	this.Address = Address;}
	public String getCity() {
		return City;
	}
	public void setCity(String City) {
		this.City = City;}
	
		public String getState() {
	return State;
}
public void setState(String state) {
	this.State = state;
}
public String getZip() {
	return Zip;
}
public void setZip(String zip) {
	this.Zip = zip;
}
@Override
public String toString() {
	return "Address [AddressID=" + AddressID + ", Address=" + Address
			+ ", city=" + City + ", state="
			+ State + ", zip=" + Zip + ", type=" + Type + "]";
}}