package ar.com.educacionit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.dao.exeptions.DuplicatedException;
import ar.com.educacionit.dao.exeptions.GenericDAOException;
import ar.com.educacionit.dao.exeptions.NonExistException;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.jdbc.AdministradorConexiones;

//ctrl+shift+o
public class ProductoDAO {

	public Producto createProducto(Producto producto) throws DuplicatedException, GenericDAOException {

		// ctrl+shift+o
		// ctrl+space

		// ctrl+shift+f
		Connection connection;
		try {
			connection = AdministradorConexiones.obtenerConexion();
		} catch (Exception e) {
			throw new GenericDAOException(e.getMessage(), e);
		}

		// select * from producto
		String sql = "INSERT INTO productos (titulo, precio, codigo, tipo_producto) VALUES ('" + producto.getTitulo() + "', '"
				+ producto.getPrecio() + "', '" + producto.getCodigo()+ "', '" + producto.getTipoProducto() + "')";

		Statement st;
		try {

			st = connection.createStatement();
			
			int resultado = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			
			ResultSet rs = st.getGeneratedKeys();
			
			Long idGenerado = null;
			
			if (rs.next()) {
				idGenerado = rs.getLong(1);
			}
			
			producto.setId(idGenerado);
		}catch(SQLIntegrityConstraintViolationException sicve) {
			throw new DuplicatedException(sicve.getMessage(), sicve);
		} catch (SQLException e) {
			throw new GenericDAOException(e.getMessage(), e);
		} finally {
			cerrarConexion(connection);
		}

		return producto;
	}

	public void deleteProducto(Long id) throws NonExistException, GenericDAOException, Exception {

		String sql = "delete from productos where id = ?";
		
		Connection connection = null; 
		
		try {
			
			connection = AdministradorConexiones.obtenerConexion();
			
			connection.setAutoCommit(false);
			
			//prepared statement
			PreparedStatement pst = connection.prepareStatement(sql);
			
			//seteo de los parametros que definimos con ?
			pst.setLong(1, id);
			
			int res = pst.executeUpdate();
			
			if(res <= 0 ) {
				throw new NonExistException("Producto inexistente id:" + id);
			}
			
			connection.commit();
			//commit
		}catch (SQLException e) {
			//rollback
			connection.rollback();
			throw new GenericDAOException("No se ha podido realizar el rollback de la transaccion",e);
		}catch (Exception e) {
			connection.rollback();
			throw e;
		}
		finally {
			cerrarConexion(connection);
		}
	}

	public Producto get(Long id) throws GenericDAOException {
		
		Connection connection = null;
		
		Producto producto = null;
		
		try {
			
			String sql = "SELECT * FROM PRODUCTOS WHERE ID =? ";

			connection = AdministradorConexiones.obtenerConexion();
			
			PreparedStatement pst = connection.prepareStatement(sql);
			
			//seteo del los parametros
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				producto = productoDesdeResultSet(rs);
			}
		} catch (Exception e) {
			throw new GenericDAOException("No se pudo obtener el producto id:" + id);
		} finally {
			cerrarConexion(connection);
		}
		
		return producto;
	}

	public Collection<Producto> obtenerTodos() throws GenericDAOException {

		Connection connection = null;
		
		Collection<Producto> productos = new ArrayList<>();
		
		try {
			
			connection = AdministradorConexiones.obtenerConexion();

			//quiero usar la conexion!!!
			String sql = "SELECT * FROM PRODUCTOS";
		
			PreparedStatement pst = connection.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
		
			while(rs.next()) {
				
				Producto producto = productoDesdeResultSet(rs);
				
				productos.add(producto);
			}
		} catch (SQLException e) {
			throw new GenericDAOException(e.getMessage(), e);
		} catch (Exception e) {
			throw new GenericDAOException(e.getMessage(), e);
		} finally {
			cerrarConexion(connection);
		}
		
		return productos;
	}

	private Producto productoDesdeResultSet(ResultSet rs) throws SQLException {
		Producto producto;
		Long idProucto = rs.getLong(1);
		String titulo = rs.getString(2);
		Float precio = rs.getFloat(3);
		String codigo = rs.getString(4);
		Long tipoProducto = rs.getLong(5);
		
		producto = new Producto(idProucto, titulo, precio, codigo, tipoProducto);
		return producto;
	}
	
	private void cerrarConexion(Connection connection) throws GenericDAOException {
		try {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new GenericDAOException("No se ha podido cerrar la conexion, verifique luego en la db", e); 
		}
	}

	public Producto updateProducto(Producto producto) throws GenericDAOException, Exception {
		
		Connection connection = null;
		
		try {
			
			String sql = "UPDATE PRODUCTOS SET TITULO = ?, PRECIO = ? WHERE ID = ?";

			connection = AdministradorConexiones.obtenerConexion();
			connection.setAutoCommit(false);

			PreparedStatement pst = connection.prepareStatement(sql);
			
			//seteo del los parametros
			pst.setString(1, producto.getTitulo());
			pst.setFloat(2, producto.getPrecio());
			pst.setLong(3, producto.getId());
			
			pst.execute();
			
			connection.commit();
		} catch (Exception e) {
			connection.rollback();
			throw new GenericDAOException("No se pudo actualizat el producto id:" + producto.getId());
		} finally {
			cerrarConexion(connection);
		}
		
		return producto;
	}

	public Collection<Producto> buscarProducto(String claveBuscadaPorElUsuario) throws GenericDAOException {
		
		Connection connection = null;
		
		Collection<Producto> productos = new ArrayList<>();
		
		try {
			
			connection = AdministradorConexiones.obtenerConexion();

			//quiero usar la conexion!!!
			String sql = "SELECT * FROM PRODUCTOS where titulo like '%"+claveBuscadaPorElUsuario+"%'";
		
			PreparedStatement pst = connection.prepareStatement(sql);
			
			//setear el dato 
			
			// pst.setString(1, claveBuscadaPorElUsuario);
			
			ResultSet rs = pst.executeQuery();
		
			while(rs.next()) {
				
				Producto producto = productoDesdeResultSet(rs);
				
				productos.add(producto);
			}
		} catch (SQLException e) {
			throw new GenericDAOException(e.getMessage(), e);
		} catch (Exception e) {
			throw new GenericDAOException(e.getMessage(), e);
		} finally {
			cerrarConexion(connection);
		}
		
		return productos;
	}
}
