package UnicornPhoenix.Database;

public class Billing {
private boolean IsInsurance;
private String EcNumber;
private String ExpirationDate;
private String ProviderID;
private String PlanCode;
private String GroupCode;
private int PersonID;
private int BillingID;

public String getIsInsurance() {
	return getIsInsurance();
}
public void setIsInsurance(boolean IsInsurance ) {
	this.IsInsurance =IsInsurance ;}
public String getEcNumber() {
	return getEcNumber();
}
public void setEcNumber(String EcNumber ) {
	this.EcNumber =EcNumber ;}
public String getExpirationDate() {
	return getExpirationDate();
}
public void setExpirationDate(String ExpirationDate ) {
	this.ExpirationDate =ExpirationDate ;}
public String getProviderID() {
	return getProviderID();
}
public void setProviderID(String ProviderID ) {
	this.ProviderID =ProviderID ;}
public String getPlanCode() {
	return getPlanCode();
}
public void setPlanCode(String PlanCode ) {
	this.PlanCode =PlanCode ;}
public String getGroupCode() {
	return getGroupCode();
}
public void setGroupCode(String GroupCode ) {
	this.GroupCode =GroupCode ;}

public void setPersonID(int PersonID ) {
	this.PersonID =PersonID ;}
public int getPersonID() {
	return PersonID ;}

	public int getBillingID() {
		return BillingID ;
	}
	public void setBillingID(int BillingID ) {
		this.BillingID =BillingID ;}
}