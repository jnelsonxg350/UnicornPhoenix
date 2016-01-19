package UnicornPhoenix.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddAddress
 */
@WebServlet("/AddAddress")
public class AddAddress extends Master {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAddress() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		body.append( "<form id=addAddress>");
		body.append("<div class='form-group'><label for='address1'>Address line 1</label><input type='text' class='form-control' id='address1' placeholder='Address' name='address1'></div>");
		
		body.append("<div class='form-group'><label for='city'>City </label><input type='text' class='form-control' id='city' placeholder='City' name='city'></div></br><div class='form-inline'>");
		body.append("<div class='form-group'>"+
				"<label for='state'>State</label>"+
			    "<select id='Select' class='form-control'>"+
			    "<option value='al'>AL</option>"+
			    "<option value='ak'>AK</option>"+
			    "<option value='az'>AZ</option>"+
			    "<option value='ar'>AR</option>"+
			    "<option vlaue='ca'>CA</option>"+
			    "<option value='co'>CO</option>"+
			    "<option vlaue='ct'>CT</option>"+
		    "<option value='de'>DE </option>"+
			    "<option value='fl'>FL</option>"+
			    "<option value='ga'>GA</option>"+
			    "<option value='hi'>HI</option>"+
			    "<option value='id'>ID </option>"+
			    "<option value='il'>IL</option>"+
			    "<option value='in'>IN </option>"+
			    "<option value='ia'>IA</option>"+
			    "<option value='ks'>KS</option> "+
			    "<option value='ky'>KY</option> "+
			    "<option value='la'>LA</option> "+
			    "<option value='me'>ME</option>"+
			    "<option value='md'>MD</option> "+
			    "<option value='ma'>MA</option> "+
			    "<option value='mi'>MI</option> "+
		    "<option value='mn'>MN</option> "+
			    "<option value='ms'>MS</option> "+
			    "<option value='mo'>MO</option> "+
			    "<option value='mt'>MT</option> "+
			    "<option value='ne'>NE</option> "+
			    "<option value='nv'>NV</option> "+
			    "<option value='nh'>NH</option> "+
			    "<option value='nj'>NJ</option> "+
			    "<option value='nm'>NM</option> "+
			    "<option value='ny'>NY</option> "+
			    "<option value='nc'>NC</option> "+
			    "<option value='nd'>ND</option> "+
			    "<option value='oh'>OH</option> "+
			    "<option value='ok'>OK</option> "+
				"<option value='or'>OR</option> "+
				"<option value='pa'>PA</option> "+
				"<option value='ri'>RI</option> "+
				"<option value='sc'>SC</option> "+
				"<option value='ds'>SD</option> "+
				"<option value='tn'>TN</option> "+
				"<option value='tc'>TX</option> "+
				"<option value='ut'>UT</option> "+
				"<option value='vt'>VT</option> "+
				"<option value='va'>VA</option> "+
				"<option value='wa'>WA</option> "+
				"<option value='wv'>WV</option> "+
				"<option value='wi'>WI</option> "+
				"<option value='wy'>WY</option>"+
				"</select></div></br></br>");
		body.append("<div class='form-inline'><label for='zipCode'>ZipCode </label><input type='text' name='zipcode' class='form-control' id='zip' placeholder='ZipCode'></br>");
		body.append("<div class='form-group'>"+
			    "<label for='addressType'>Address Type:  </label>"+
			    "<label class='inline'>"+
			    "<input type='radio' id='addressHome' value='home'>Home </label>"+
			    "<label class='inline'>"+
			    "<input type='radio' id='addressWork' value='work'>Work </label>"+
			    "<label class='inline'>"+
			    "<input type='radio' id='addressPoBOx' value='poBox'>PO Box </label>"+
			    "<label class='inline'>"+
		    "<input type='radio' id='addressOther' value='other'>Other </label></div></br>");
		body.append("</div>"+
		    	"<div class='form-group'>"+
		    		"<button type='submit' class='btn btn-default'>Submit</button></div></form>");
		super.doGet(request, response);
	}
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
