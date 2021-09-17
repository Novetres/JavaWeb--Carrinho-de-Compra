<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bootstrap/js/jquery-3.6.0.min.js"></script>

<title>Editar item</title>
<link rel="icon" href="img/favicon.png">
</head>
<body class="bg-dark ">
	<br>
	<div class="bg-warning">
	<h1 class="text-center text-danger">Editar item</h1>
	</div>
	<br>
	<br>
	
	<form name="frmContato" action="update">
	
	
	
	<div class="row mb-2">
  <label for="colFormLabelSm" class="rounded col-sm-1 col-form-label col-form-label-sm text-dark text-center bg-warning">Código</label>
  <div class="col-sm-1">
   <input type="text" class="form-control form-control-sm" id="colFormLabelSm" name="codigo"  readonly  value="<%out.println(request.getAttribute("codigo"));%>"> 
  </div>
</div>
	
	
		<div class="row mb-2">
  <label for="colFormLabelSm" class="rounded col-sm-1 col-form-label col-form-label-sm text-dark text-center bg-warning">Item</label>
  <div class="col-sm-3">
    <input type="text" class="form-control form-control-sm" id="colFormLabelSm" name="item"  readonly  value="<%out.println(request.getAttribute("item"));%>">
  </div>
</div>
	
	

				<div class="row mb-2">
  <label for="colFormLabelSm" class="rounded col-sm-1 col-form-label col-form-label-sm text-dark text-center bg-warning">Quantidade</label>
  <div class="col-sm-2">
    <input type="text" class="form-control form-control-sm" id="colFormLabelSm" name="quantidade"   value="<%out.println(request.getAttribute("quantidade"));%>">
  </div>
</div>

	
	
				<div class="row mb-2">
  <label for="colFormLabelSm" class="rounded col-sm-1 col-form-label col-form-label-sm text-dark text-center bg-warning">Preço</label>
  <div class="col-sm-2">
    <input type="text" class="form-control form-control-sm" id="colFormLabelSm" name="preco"    readonly value="<%out.println(request.getAttribute("preco"));%>">
  </div>
</div>

	


		<div class="d-grid gap-2 col-6 mx-auto mt-3">
		
	
		<a   type="button" class="btn btn-danger text-warning rounded-bottom" onclick="validar()"> EDITAR </a>

		</div>
		
		
		

	</form>
	
	

	<script src="scripts/valida.js"></script>
</body>
</html>