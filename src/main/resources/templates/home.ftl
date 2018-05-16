<html>
<head></head>

<body>
<h1>This is the homepage for the user ${user.username}</h1>

<security:authorize access="hasRole('ROLE_USER')">
    This text is only visible to a user
    <br />
</security:authorize>

<security:authorize access="hasRole('ROLE_ADMIN')">
    This text is only visible to an admin
    <br />
</security:authorize>


<button class="btn-warning"><a class="btn-warning" href="<c:url value='/logout' />">Logout</a></button>
</body>
</html>