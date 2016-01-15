package UnicornPhoenix.Database;

import java.sql.Date;

public class BillingInformation {
	private boolean IsInsurance;
	private String CreditCardNumber;
	private Date ExpirationDate;
	private int ProviderID;
	private String PlanCode;
	private String GroupCode;
	private int PersonID;
	private int BillingID;
	private String CSV;
	public boolean isInsurance() {
		return IsInsurance;
	}
	public void setIsInsurance(boolean isInsurance) {
		IsInsurance = isInsurance;
	}
	public String getCreditCardNumber() {
		return CreditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		CreditCardNumber = creditCardNumber;
	}
	public Date getExpirationDate() {
		return ExpirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		ExpirationDate = expirationDate;
	}
	public int getProviderID() {
		return ProviderID;
	}
	public void setProviderID(int providerID) {
		ProviderID = providerID;
	}
	public String getPlanCode() {
		return PlanCode;
	}
	public void setPlanCode(String planCode) {
		PlanCode = planCode;
	}
	public String getGroupCode() {
		return GroupCode;
	}
	public void setGroupCode(String groupCode) {
		GroupCode = groupCode;
	}
	public int getPersonID() {
		return PersonID;
	}
	public void setPersonID(int personID) {
		PersonID = personID;
	}
	public int getBillingID() {
		return BillingID;
	}
	public void setBillingID(int billingID) {
		BillingID = billingID;
	}
	public String getCSV() {
		return CSV;
	}
	public void setCSV(String cSV) {
		CSV = cSV;
	}
	
}