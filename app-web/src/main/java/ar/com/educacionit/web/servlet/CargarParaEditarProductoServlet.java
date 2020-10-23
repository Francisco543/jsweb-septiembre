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

@WebServlet("/CargarParaEditarProductoServlet")
public class CargarParaEditarProductoServlet extends HttpServlet {

	//f3
	private ProductoService productoService = new ProductoServiceImpl();
	
	@Override
	//alt+shit+r
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		String target;
		try {
			
			Producto producto = productoService.obtenerProductoById(Long.parseLong(id));
			
			//guardo en el request el listado para que la jsp que reciba la data
			
			request.setAttribute("producto", producto);
			
			target = "/jsp/editar.jsp";
		}catch (Exception e) {
			
			target = "/jsp/listado.jsp";
			
			Collection<Producto> listado;
			try {
				listado = productoService.obtenerProductos();
				request.setAttribute("error", e.getMessage());
			} catch (ServiceException e1) {
				request.setAttribute("error", e.getMessage());
				request.setAttribute("listado", new ArrayList<>());	
			}
		}
		
		//redireccion
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
		rd.forward(request, response);
	}
}
