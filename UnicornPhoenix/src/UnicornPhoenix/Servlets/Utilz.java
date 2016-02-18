package UnicornPhoenix.Servlets;

public class Utilz {
	public static String getTemplate(String body)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html> " +
	"<html lang='en'> " +
	  "<head> " +
	    "<meta charset='utf-8'> " +
	    "<meta http-equiv='X-UA-Compatible' content='IE=edge'> " +
	    "<meta name='viewport' content='width=device-width, initial-scale=1'> " +
	    "<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags --> " +
	    "<meta name='description' content=''> " +
	    "<meta name='author' content=''> " +
	    "<link rel='icon' href='../../favicon.ico'> " +
	
	    "<title>Unicorn Phoenix</title> " +
	
	    "<!-- Bootstrap core CSS --> " +
	    "<link href='/UnicornPhoenix/css/bootstrap.min.css' rel='stylesheet'> " +
	    "<link href='/UnicornPhoenix/css/site.css' rel='stylesheet'> " +
	    
	    "<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries --> " +
	    "<!--[if lt IE 9]> " +
	      "<script src='https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js'></script> " +
	      "<script src='https://oss.maxcdn.com/respond/1.4.2/respond.min.js'></script> " +
	    "<![endif]--> " +
	  "</head> " +
	
	  "<body role='document'> " +
	
	    "<!-- Fixed navbar --> " +
	    "<nav class='navbar navbar-inverse navbar-fixed-top'> " +
	      "<div class='container'> " +
	        "<div class='navbar-header'> " +
	         "<button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#navbar' aria-expanded='false' aria-controls='navbar'> " +
	            "<span class='sr-only'>Toggle navigation</span> " +
	            "<span class='icon-bar'></span> " +
	            "<span class='icon-bar'></span> " +
	            "<span class='icon-bar'></span> " +
	          "</button> " +
	          "<a class='navbar-brand' href='#'>Unicorn Phoenix <span class='glyphicon glyphicon-fire' aria-hidden='true'></span></a> " +
	        "</div> " +
	        "<div id='navbar' class='navbar-collapse collapse'> " +
	          "<ul class='nav navbar-nav'> " +
	            "<li class='dropdown'><a href='/UnicornPhoenix/Default'>Home</a></li> " +
	            "<li class='dropdown'> " +
	              "<a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>Person <span class='caret'></span></a> " +
	              "<ul class='dropdown-menu'> " +
	                "<li><a href='/UnicornPhoenix/AllPeople'><span class='glyphicon glyphicon-list' aria-hidden='true'></span> &nbsp List</a></li> " +
	                "<li><a href='/UnicornPhoenix/AddPerson'><span class='glyphicon glyphicon-plus' aria-hidden='true'></span> &nbsp Add</a></li> " +
	              "</ul> " +
	            "</li> " +
	          "</ul> " +
	        "</div><!--/.nav-collapse --> " +
	      "</div> " +
	    "</nav> " +
	
	    "<div class='container theme-showcase' role='main' style='margin-top: 75px;'> " +
	
	   body +
	
	
	    "</div> <!-- /container --> " +
	
	
	   "<!-- Bootstrap core JavaScript " +
	    "================================================== --> " +
	    "<!-- Placed at the end of the document so the pages load faster --> " +
	    "<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script> " +
	    "<script src='/UnicornPhoenix/js/bootstrap.min.js'></script> " +
	    "<script src='/UnicornPhoenix/js/validator.js'></script> " +
	    "<script src='/UnicornPhoenix/js/site.js'></script> " +
	  "</body> " +
	"</html> ");
		
		return sb.toString();
	}
}
