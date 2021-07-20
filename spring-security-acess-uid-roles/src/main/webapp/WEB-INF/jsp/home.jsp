<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/demo.css">
<title>Hello</title>
</head>
<body>
	<h3>Dream cool home page</h3>
	<p>
		User: <security:authentication property="principal.username" /><br>
		Roles(s): <security:authentication property="principal.authorities" />
	</p>
	<hr>
	You are logged in to application.
	<!-- Add a link for the manager roles -->
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership meeting</a>
			(Only for manager folks)
		</p>
	</security:authorize>
	<!-- Add a link for the Admin roles -->
	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">Admin meeting</a>
			(Only for manager folks)
		</p>
	</security:authorize>
	<hr>
	<form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>