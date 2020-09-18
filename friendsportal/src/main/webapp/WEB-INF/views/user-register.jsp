<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<center>
		<spring:form action="user-register-process" method="post"
			modelAttribute="user">
			<p>
				<spring:label path="name">Name</spring:label>
				<spring:input path="name" />
			</p>
			<p>
				<spring:label path="email">Email</spring:label>
				<spring:input path="email" />
			</p>
			<p>
				<spring:label path="password">Password</spring:label>
				<spring:input path="password" />
			</p>
			<p>
				<spring:label path="mobile">Mobile</spring:label>
				<spring:input path="mobile" />
			</p>
			<p>
				<spring:label path="gender">Gender</spring:label>
				<spring:input path="gender" />
			</p>
			<p>
				<spring:label path="age">Age</spring:label>
				<spring:input path="age" />
			</p>
			<center>
				<input type="submit" value="register" />
			</center>

		</spring:form>
	</center>
</body>
</html>