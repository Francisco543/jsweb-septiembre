package ar.com.educacionit.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.exeptions.ServiceException;
import ar.com.educacionit.service.impl.ProductoServiceImpl;

@WebServlet("/EliminarProductoServlet")
public class EliminarProductoServlet extends HttpServlet {

	private ProductoService productoService = new ProductoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		if(id == null || id.trim().equals("")) {
			
			response.sendRedirect(request.getContextPath()+ "/jsp/listado.jsp");
		}
		
		Long idL = Long.parseLong(id);
		
		try {
			productoService.eliminarProducto(idL);
			
			request.setAttribute("exito", "Se ha eliminado el producto id:" + idL);
			
		} catch (ServiceException e) {
			
			request.setAttribute("error", e.getMessage());
		}

		Collection<Producto> listado;
		try {

			listado = productoService.obtenerProductos();
			//guardo en el request el listado para que la jsp que reciba la data
			
			request.setAttribute("listado", listado);
		} catch (ServiceException e) {
			request.setAttribute("error", e.getMessage());			
			request.setAttribute("listado", new ArrayList<>());
		}

		//redireccion
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/listado.jsp");
		rd.forward(request, response);
	}
}
