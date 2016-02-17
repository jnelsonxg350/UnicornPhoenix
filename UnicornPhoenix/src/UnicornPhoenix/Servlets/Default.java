package UnicornPhoenix.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Default")
public class Default extends Master {
	private static final long serialVersionUID = 1L;
       
    public Default() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//add content
    	
    	body.append("<div><img class='center-block' src='http://images.cooltext.com/4590117.png'></br><h2 style='text-align:center;' class='textcolor'> Created By: Gregg Blacker, Tessa Huber And Dennis T");
    	body.append("<div><img class='center-block'src='http://skullappreciationsociety.com/wp-content/uploads/2015/08/Zombie_Unicorn_zombicorn_by_lordnetsua-d76rbxj.jpg'>");
		
    	//call the super method
		super.doGet(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
