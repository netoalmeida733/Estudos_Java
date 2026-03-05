<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
	
%>
<!DOCTYPE html>
<html lang=pt-br>
<head>
<meta charset="utf-8">
<title>Agenda para contatos</title>
<link rel="icon" href="imagens/phone_4639549.png">
<link rel="stylesheet" href="style.css">
</head>
<style>
#tabela {
	margin-top: 50px;
	
}
#tabela th {
	border: 2px solid  #ddd;
	padding: 15px;
	background-color: skyblue;
	color: white;
	border-radius: 10px;
}
#tabela td {
	border: 2px solid  #ddd;
	padding: 15px;
	border-radius: 10px;
}
/* botão base */
.btn {
    display: inline-block;
    padding: 6px 12px;
    margin: 2px;
    border-radius: 8px;
    text-decoration: none;
    font-weight: bold;
    font-size: 14px;
    color: #fff;
    transition: 0.3s;
}

/* botão editar */
.btn.editar {
    background: linear-gradient(135deg, #1e90ff, #0047ff);
}

/* botão excluir */
.btn.excluir {
    background: linear-gradient(135deg, #ff3b3b, #c40000);
}
h1 {
       display: block;          /* força quebrar linha */
    margin-bottom: 15px;     /* espaço abaixo do título */
    padding: 14px 28px;
    border-radius: 14px;
    font-weight: 700;
    font-size: 22px;
    letter-spacing: 1px;
    color: #fff;
    background: linear-gradient(135deg, #1e90ff, #00bfff);
    box-shadow: 0 8px 20px rgba(30, 144, 255, 0.35);
    text-transform: uppercase;
    position: relative;
}
</style>
<body>
	<h1>Agenda de Contatos</h1>
	<a href="novo.html" class="btn editar"> Novo Contato</a>
	<a href="report" class="btn excluir">  Relatório</a>
	<table id="tabela">
		<thead>
			<th>Id</th>
			<th>Nome</th>
			<th>Fone</th>
			<th>Email</th>
			<th>Opçoes</th>
		</thead>
		<tbody>
		<% for (int i = 0; i < lista.size(); i++) {%>
			<tr>
				<td><%=lista.get(i).getIdcon() %></td>
				<td><%=lista.get(i).getNome() %></td>
				<td><%=lista.get(i).getFone() %></td>
				<td><%=lista.get(i).getEmail() %></td>
				<td><a href="select?idcon=<%=lista.get(i).getIdcon()%>" class="btn editar">Editar</a> 
					<a  href="delete?idcon=<%=lista.get(i).getIdcon()%>"  class="btn excluir" onclick=" return confirmar()">Excluir</a> 
				</td>
			</tr>
		<%} %>
		</tbody>	
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>