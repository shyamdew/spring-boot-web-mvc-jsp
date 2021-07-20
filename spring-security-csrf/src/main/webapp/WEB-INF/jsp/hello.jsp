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
		<form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout" >
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</body>
</html>