<!-- DIRECTIVA -->
<%@page import="ar.com.educacionit.domain.Producto"%>
<%@page import="java.util.Collection"%>

<!-- SCRIPTLET -->
<%
	Collection<Producto> listado = (Collection<Producto>)request.getAttribute("listado");
%>

<html>
	<head>
		<!-- boostrap -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		<script type="text/javascript">
			function editarProducto(id) {
				
				var confirma = confirm('Desea eliminar el producto : id = '+ id );
				
				if(confirma) {
					window.location = '<%=request.getContextPath()%>/EliminarProductoServlet?id='+id;
				}
				
				return false;
			}
		</script>
	</head>
	<body>
		<div class="container-fluid">
			<%@include file="navbar.jsp" %>
			
			<% if(request.getAttribute("error") != null) {%>
				<div class="row">
					<div class="col-12">
						<div class="alert alert-danger" role="alert">
						  <%=request.getAttribute("error")%>
						</div>
					</div>
				</div>
			<% }%>
			<% if(request.getAttribute("exito") != null) {%>
				<div class="row">
					<div class="col-12">
						<div class="alert alert-success" role="alert">
						  <%=request.getAttribute("exito")%>
						</div>
					</div>
				</div>
			<% }%>
			<div class="row">
				<table class="table">
					  <thead>
					    <tr>
					      <th scope="col">ID</th>
					      <th scope="col">CODIGO</th>
					      <th scope="col">TITULO</th>
					      <th scope="col">PRECIO</th>
					      <th scope="col">TIPO</th>
					      <th scope="col">&nbsp;</th>
					    </tr>
					  </thead>
					  <tbody>
					   
					   	<% for(Producto producto: listado) { %>
							<tr>
								<th scope="row"><%=producto.getId() %></th>
								<td><%=producto.getCodigo() %></td>
								<td><%=producto.getTitulo() %></td>
								<td><%=producto.getPrecio() %></td>
								<td><%=producto.getTipoProducto() %></td>
								<td>
									<a href="<%=request.getContextPath() %>/CargarParaEditarProductoServlet?id=<%=producto.getId() %>" class="btn btn-primary btn-md active" role="button" aria-pressed="true">Editar</a>
									<button onclick="editarProducto(<%=producto.getId()%>)" type="button" class="btn btn-danger">Eliminar</button>
								</td>	
							</tr>
						<% } %>
					  </tbody>
				</table>
			</div>
		</div>
	</body>
</html>