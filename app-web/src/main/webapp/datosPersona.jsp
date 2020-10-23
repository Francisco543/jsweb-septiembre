<html>
	<head>
		<!-- boostrap -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	</head>
	
	<body>
	
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<%=request.getAttribute("nombreRecibido") %>
					<%=request.getAttribute("apellidoRecibido") %>
					<%=request.getAttribute("domicilioRecibido") %>
					<%=request.getAttribute("paisRecibido") %>
				</div>	
				<a href="<%=request.getContextPath() %>" >Volver</a>		
			</div>
		</div>
	</body>
</html>
