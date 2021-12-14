<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="registrazione" method="post">

<label for="nome"> Inserisci il nome</label>
	<input type="text" id="nome" name="nome" placeholder="inserisci il tuo nome">
	
<label for="cognome"> Inserisci il cognome</label>
	<input type="text" id="cognome" name="cognome" placeholder="inserisci il tuo cognome">
	
<label for="username"> Inserisci la tua username</label>
	<input type="text" id="username" name="username" placeholder="inserisci la tua username">
	
<label for="password"> Inserisci la tua passoword</label>
	<input type="password" id="password" name="password" placeholder="inserisci la tua password">

<input type="submit" value="Salva">
</form>

</body>
</html>