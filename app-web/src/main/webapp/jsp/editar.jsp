<%@page import="ar.com.educacionit.domain.Producto"%>

<% 
	Producto producto = (Producto)request.getAttribute("producto");
%>
<html>
	<head>
		<!-- boostrap -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
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
			
			<div class="row">
			
				<div class="col-md-12 col-md-8 col-lg-9 col-xl-6">
					<form action="<%=request.getContextPath() %>/ActualizarProductoServlet" method="post">
					  
				   	<div class="form-group">
					    <label for="id">ID</label>
					    <input name="id" readonly="readonly" type="text" class="form-control" id="id" value="<%=producto.getId()%>">
					  </div>
					  
					  <div class="form-group">
					    <label for="codigo">Código</label>
					    <input name="codigo" readonly="readonly" type="text" class="form-control" id="codigo" value="<%=producto.getCodigo()%>">
					  </div>
					  
					  <div class="form-group">
					    <label for="titulo">Título</label>
					    <input name="titulo" type="text" class="form-control" id="titulo" value="<%=producto.getTitulo()%>">
					  </div>
					  
					  <div class="form-group">
					    <label for="precio">Precio</label>
					    <input name="precio" type="text" class="form-control" id="precio" value="<%=producto.getPrecio()%>">
					  </div>
					  
					  <div class="form-group">
					    <label for="tipoProducto">Tipo Producto</label>
					    <select name="tipoProducto" class="form-control" id="tipoProducto">
					    	<!-- for -->
					    	<!-- selected -->
					      <option value="1">Herramientas</option>
					      <option value="2">Electrodomesticos</option>
					    </select>
					  </div>
					  
					  <button type="submit" class="btn btn-primary">Actualizar</button>
					</form>
				</div>
				
			</div>	
		</div>
	</body>
</html>