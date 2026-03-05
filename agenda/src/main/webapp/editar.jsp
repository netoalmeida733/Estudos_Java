<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="icon" href="imagens/phone_4639549.png">
<link rel="stylesheet" href="style.css">
<title>Agenda de Contatos</title>
</head>
<style>
#container {
	display: flex;
	align-items: center;
	padding: 5px;
}

#container input {
	display: flex;
	align-items: center;
	width: 300px; /* largura da caixa */
	height: 40px; /* altura da caixa */
	font-size: 16px; /* tamanho do texto */
	padding: 8px;
	margin-bottom: 10px;
	
}
#caixa3{
	display: flex;
	align-items: center;
	padding: 5px;
	border: 2px solid red;
	border-radius: 10px
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
.btn {
    width: 320px;
    display: inline-block;
    padding: 6px 12px;
    margin: 2px;
    border-radius: 8px;
    text-decoration: none;
    font-weight: bold;
    font-size: 14px;
    color: #fff;
    transition: 0.3s;
    background: linear-gradient(135deg, #1e90ff, #0047ff);
    cursor: pointer;
    
}
</style>
<body>
	<h1>Editar Contato</h1>
	<form name="frmContato" action="update" method="post">
		
		<table id="container">
			<tr>
				<td><input type="text" name="idcon" id="caixa3" readonly required value="<%out.print(request.getAttribute("idcon")); %>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" required  value="<%out.print(request.getAttribute("nome")); %>"></td>
			</tr>
			<tr>
				<td><input type="text" name="fone"  required value="<%out.print(request.getAttribute("fone")); %>"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" required value="<%out.print(request.getAttribute("email")); %>"></td>
			</tr>
		</table>
		<input class="btn" type="submit" value="Salvar" onclick="validar()">
	</form>

</body>
</html>