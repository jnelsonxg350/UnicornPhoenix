package UnicornPhoenix.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Master extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StringBuilder body;
   
    public Master() {
        super();
    	body = new StringBuilder();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.write(Utilz.getTemplate(body.toString()));		
		pw.close();
		body = new StringBuilder();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	}
}
