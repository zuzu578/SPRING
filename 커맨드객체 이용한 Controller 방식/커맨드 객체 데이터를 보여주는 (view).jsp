<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	${studentInformation.name } 
	${studentInformation.classNumber } 
	${studentInformation.grade } 
	${studentInformation.height } 
</h1>
</body>
</html>
