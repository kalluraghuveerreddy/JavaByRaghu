<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<p align="center">Login</p>

	<center>
		<form action="user-login-process" method="post">

			<p>
				<label for="email">Email</label> <input type="email" id="email"
					name="email" />
			</p>
			<p>
				<label for="password">Password</label> <input type="password" id="password"
					name="password" />
			</p>

			<center>
				<input type="submit" value="login" />
			</center>

		</form>
	</center>
</body>
</html>