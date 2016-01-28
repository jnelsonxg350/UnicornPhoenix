package UnicornPhoenix.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import UnicornPhoenix.Database.*;
@WebServlet("/DeleteEmail")
public class DeleteEmail extends Master {
	private static final long serialVersionUID = 1L;
    public DeleteEmail() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UnicornPhoenixDB db = new UnicornPhoenixDB();
		db.deleteEmail(request.getParameter("id"));
	}

}
