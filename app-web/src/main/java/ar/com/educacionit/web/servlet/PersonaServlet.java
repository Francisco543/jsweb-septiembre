package ar.com.educacionit.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String domicilio = request.getParameter("domicilio");
		String pais = request.getParameter("pais");
		//ctrl++shit+i
		System.out.println(nombre);
		System.out.println(apellido);
		System.out.println(domicilio);
		System.out.println(pais);
		
		//sevlet-api.jar
		
		//los datos que le enviamos desde este servlet
		request.setAttribute("nombreRecibido", nombre);
		request.setAttribute("apellidoRecibido", apellido);
		request.setAttribute("domicilioRecibido", domicilio);
		
		Integer paisInt = Integer.parseInt(pais);
		String paisRecibido;
		switch (paisInt) {
		case 1:
			paisRecibido = "Argentina";
			break;
		case 2:
			paisRecibido = "Brasil";
			break;
		case 3:
			paisRecibido = "Chile";
			break;
		default:
			paisRecibido = "No informado";
			break;
		}
		
		request.setAttribute("paisRecibido", paisRecibido);
		
		//jsp a donde va la peticion!
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/datosPersona.jsp");
		rd.forward(request, response);
	}

}
