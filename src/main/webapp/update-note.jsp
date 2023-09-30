<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.List"%>
<%@page import="com.entities.Note"%>

<%
 	//Session s = FactoryProvider.getFactory().openSession() ;
	//s.get(Note,)
%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>add note</title>
<%@include file="all.jsp"%>

</head>
<body>

	<div class="container">
		<%@include file="nav.jsp"%>
		<h2 class="mt-2">Take a note!</h2>

		<form action="save-note" method="POST">
			<div class="form-group">
				<label for="exampleInputEmail1">Title</label> <input
					 class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" required name="note-title">
					 <small id="emailHelp"class="form-text text-muted">Please add title</small>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Description</label> <textarea
					 class="form-control" id="exampleInputPassword1" required name="note-description" rows=15></textarea>
			</div>
			<div class="text-right">
				<button type="submit" class="btn btn-danger">Submit</button>
			</div>
		</form>
	</div>

</body>
</html>