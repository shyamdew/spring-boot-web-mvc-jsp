<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		 <link rel="stylesheet" type="text/css" href="css/demo.css">
		<title>Hello</title>
	</head>
	<body>
		
		<h3>Dream cool home page</h3>
		<hr>
		You are logged in to application.
		<hr>
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" >
		</form:form>
	</body>
</html>