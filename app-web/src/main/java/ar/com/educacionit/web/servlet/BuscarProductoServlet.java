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
import ar.com.educacionit.service.impl.ProductoServiceImpl;

@WebServlet("/BuscarProductoServlet")
public class BuscarProductoServlet extends HttpServlet {

	//f3
	private ProductoService productoService = new ProductoServiceImpl();
	
	@Override
	//alt+shit+r
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String claveBuscadaPorElUsuario = request.getParameter("claveBusqueda");
		
		try {
			
			Collection<Producto> listado = productoService.buscarProducto(claveBuscadaPorElUsuario);
			
			//guardo en el request el listado para que la jsp que reciba la data
			
			request.setAttribute("listado", listado);
			
		}catch (Exception e) {
			
			request.setAttribute("listado", new ArrayList<>());
			
			request.setAttribute("error", e.getMessage());
		}
		
		//redireccion
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/listado.jsp");
		rd.forward(request, response);
	}
}
