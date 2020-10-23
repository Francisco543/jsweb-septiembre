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

@WebServlet("/ActualizarProductoServlet")
public class ActualizarProductoServlet extends HttpServlet {

	private ProductoService productoService = new ProductoServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String codigo = request.getParameter("codigo");
		String precio = request.getParameter("precio");
		String tipoProducto = request.getParameter("tipoProducto");
		
		Float precioF = Float.parseFloat(precio);
		Long tipoProductoL = Long.parseLong(tipoProducto);
		
		Producto producto = new Producto(Long.parseLong(id), titulo,precioF,codigo,tipoProductoL);
		
		String target;
		
		try {
			
			producto = productoService.actualizarProducto(producto);
			
			Collection<Producto> listado = productoService.obtenerProductos();
			
			//guardo en el request el listado para que la jsp que reciba la data
			
			request.setAttribute("listado", listado);
			
			target = "/jsp/listado.jsp";
			
			request.setAttribute("exito", "Se ha actualizado el producto exitosamente");
		} catch (ServiceException e) {
			
			request.setAttribute("listado", new ArrayList<>());
			
			request.setAttribute("error", e.getMessage());
			
			target = "/jsp/editar.jsp";
			
			request.setAttribute("error", e.getMessage());
			
			request.setAttribute("producto", producto);
		}
		
		//redireccion!
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
		rd.forward(request, response);
	}
}
