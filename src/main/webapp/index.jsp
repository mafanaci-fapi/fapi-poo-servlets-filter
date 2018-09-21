<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAPI - Orientação a Objetos II - Servlets - Login
	Aluno</title>
</head>
<body>
	<div id="formLoginSession">
		Login Session:
		<form action="login" method="post">
			<label>Email:</label> <input type="text" name="email"> <label>Senha:</label><input
				type="password" name="senha"> <input type="submit"
				value="Enviar">
		</form>
	</div>
	<hr>
	<div id="formLogout">
		<form action="logout" method="post">
			<input type="submit" value="Deslogar">
		</form>
	</div>

</body>
</html>
