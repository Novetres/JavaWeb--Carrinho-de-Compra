<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bootstrap/js/jquery-3.6.0.min.js"></script>



<title>Carrinho de Compra</title>
<link rel="icon" href="img/favicon.png">

</head>
<body class="bg-warning " >
	<br>

	<div class="bg-danger">

		<h1 class="text-center text-warning">Carrinho de compra</h1>
	</div>
	<br>
	<div class="d-grid gap-2 col-3 mx-auto mt-4">
		<a href="novo.html" type="button" class="btn btn-dark text-danger">NOVO ITEM</a>
		 <a type="button" href="report" class="btn btn-dark text-danger">RELATÓRIO</a>
	</div>

<table  class="table mt-3 table-bordered table-sm table-dark table-striped">
  <thead >
    <tr >
      <th scope="col" class="text-center">Codigo</th>
      <th scope="col"  class="text-center">Item</th>
      <th  scope="col"  class="text-center">Quantidade</th>
      <th  scope="col" class="text-center">Preço</th>
      <th scope="col" class="text-center">Opções</th>
    
    </tr>
  </thead>


 <tbody>
 
 <%
 
@SuppressWarnings("unchecked")
// a linha abaixo recebe a lista da camada controller armazenando no vetor

ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("itens");
for (int i=0; i<lista.size();i++){
%>
    <tr>
  <td><%=lista.get(i).getCodigo()%></td>  
<td><%=lista.get(i).getItem()%></td>

<td><%=lista.get(i).getQuantidade()%></td>
<td ><%=lista.get(i).getPreco()%></td>
  <td><a  href="select?codigo=<%=lista.get(i).getCodigo()%>" class="btn btn-dark text-danger text-center"> Editar</a> 
  <a href="javascript: confirmar(<%=lista.get(i).getCodigo()%>)" type="button" class="btn btn-dark text-danger  text-center" > Excluir</a></td>
  
   
    </tr>
    
    <%
   
}
%>

 </tbody>

 </table>
 
 
 
 
 
 
  <script src="scripts/confirmador.js"></script>
  </body>
  </html>
  
 
