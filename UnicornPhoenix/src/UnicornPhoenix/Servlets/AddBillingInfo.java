package UnicornPhoenix.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddBillingInfo")
public class AddBillingInfo extends Master {
	private static final long serialVersionUID = 1L;
       
   
    public AddBillingInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//add content
		body.append("<form id=billingForm>");
    	body.append("<label for='IsInsured'> do you have insurace? :</label>"+
			    "<div class='in-line'><input type='radio' id='isInsured' value='y' name='yesInsured'>Yes </label></div>"+
			    "<div class='in-line'><input type='radio' id='isnotInsured' value='n' name='notInsured'>No </label></div>");
    	body.append("<div class='form-group'>"+
			    "<label for='CreditCardNmber'>Credit Card Number:</label>"+
			    "<input type='text' class='form-control' id='creditCardNumber' placeholder='xxxxxxxxxxxxxxxx'></div>");
    	body.append("<div class='form-inline'>"+
			    "<label for='expdate'>Experation date:</label>"+
			    "<input type='date' class='form-control' id='expdate'></div>");
    	body.append("<div class='form-inline'>"+
			    "<label for='CSV'>CSV </label>"+
			    "<input type='text' class='form-control' id='CSV'></div>");
    	body.append("<div class='form-group'>"+
			    "<label for='providerID'>Provider ID </label>"+
			    "<input type='text' class='form-control' id='providerID'></div>");
    	body.append("<div class='form-group'>"+
			    "<label for='planCode'>Plan Code</label>"+
			    "<input type='text' class='form-control' id='planCode'></div>");
    	body.append("<div class='form-group'>"+
			    "<label for='groupCode'>Group Code</label>"+
			    "<input type='text' class='form-control' id='groupCode'></div>");
    	body.append("</div>"+
		    	"<div class='form-group'>"+
		    		"<button type='submit' class='btn btn-default'>Submit</button></div></form>");
    	
    	
		
    	//call the super method
		super.doGet(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
