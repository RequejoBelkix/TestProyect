package testPackage;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reloj")
public class ServietReloj extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServietReloj() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calendar calendar= GregorianCalendar.getInstance();
		
		String formato= request.getParameter("formato");
		String hora;
		if("12".equals(formato)) {
			
			hora= String.format("%s:%s:%s %s",
					calendar.get(calendar.HOUR_OF_DAY),
					calendar.get(calendar.MINUTE),
					calendar.get(calendar.SECOND),
					calendar.get(calendar.AM_PM)==0 ? "AM": "PM");
			//http://localhost:9090/ProyectoServlets/reloj?formato=12
			
		}
		else {
			hora= String.format("%s:%s:%s",
					calendar.get(calendar.HOUR_OF_DAY),
					calendar.get(calendar.MINUTE),
					calendar.get(calendar.SECOND));
		}
			
		response.getOutputStream().print(hora);
		response.getOutputStream().flush();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
