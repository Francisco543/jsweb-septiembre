package ar.com.educacionit.service.impl;

import java.util.Collection;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exeptions.DuplicatedException;
import ar.com.educacionit.dao.exeptions.GenericDAOException;
import ar.com.educacionit.dao.exeptions.NonExistException;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.exeptions.ServiceException;

public class ProductoServiceImpl implements ProductoService {

	private ProductoDAO productoDao;
	
	public ProductoServiceImpl() {
		this.productoDao = new ProductoDAO();
	}
	
	/**
	 * Obtiene producto por medio de su id
	 */
	public Producto obtenerProductoById(Long id) throws ServiceException {
		
		try {
			return this.productoDao.get(id);
		} catch (GenericDAOException e) {
			throw new ServiceException("Error de servicio, consultando producto", e);
		} finally {
			//siempre se ejecuta
		}
	}

	public void eliminarProducto(Long id) throws ServiceException {
		//f3
		//ctrl+t -> el impl de la interfaz
		//alt ->
		//alt <-
		try {
			this.productoDao.deleteProducto(id);
		} catch (NonExistException e) {
			throw new ServiceException("No existe el producto con id: "+ id, e);
		} catch (GenericDAOException e) {
			throw new ServiceException("No se ha podido eliminar el producto id: "+id+", error inesperado", e);
		} catch (Exception e) {
			throw new ServiceException("Error interno, no controlado, por favor reintente", e);
		}
	}
	
	@Override
	public Producto nuevoProducto(Producto producto) throws ServiceException {
		try {
			return this.productoDao.createProducto(producto);
		} catch (DuplicatedException e) {
			throw new ServiceException("Producto duplicado id:" + producto.getId(), e);
		} catch (GenericDAOException e) {
			throw new ServiceException("Error interno, no se ha podido crear el producto, por favor reintente", e);
		}
	}

	@Override
	public Collection<Producto> obtenerProductos() throws ServiceException {
		try {
			return this.productoDao.obtenerTodos();
		} catch (GenericDAOException e) {
			throw new ServiceException("Error interno, por favor reintente", e);
		}
	}
	
	//ctrl+space
	@Override
	public Producto actualizarProducto(Producto producto) throws ServiceException {
		try {
			return this.productoDao.updateProducto(producto);
		} catch (DuplicatedException e) {
			throw new ServiceException("Producto duplicado id:" + producto.getId(), e);
		} catch (GenericDAOException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (Exception e) {
			throw new ServiceException("Error interno, no se ha podido crear el producto, por favor reintente", e);
		}
	}
	
	//ctrl+space
	@Override
	public Collection<Producto> buscarProducto(String claveBuscadaPorElUsuario) throws ServiceException {
		try {
			return this.productoDao.buscarProducto(claveBuscadaPorElUsuario);
		} catch (GenericDAOException e) {
			throw new ServiceException("Error interno, no se ha podido obtener el listado de productos, por favor reintente", e);
		}
	}
}