<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="com.entities.Note"%>
<%
	Session s = FactoryProvider.getFactory().openSession();
	Query q = s.createQuery("from Note");
	List<Note> notes = q.list();
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>view note</title>
<%@include file="all.jsp"%>

</head>
<body>

	<div class="container">
		<%@include file="nav.jsp"%>
		<h2 class="mt-2">Notes</h2>
		<%if(notes.size() == 0){ %>
			<div class="card" style="margin-bottom : 5px">
			<img class="card-img-top" src="img/notes.png" style="width: 50%"  alt="Card image cap">
			<div class="card-body">
				<div ><h5 class="card-title text-white">Please create a Note !</h5></div>
			</div>
		</div>
		<% } %>
		<% for(Note note : notes){ %>
		<div class="card" style="margin-bottom : 8px">
		
			<div class="card-body"  style="background: #4ab8a1">
			<div class="row">
				<div class="col-md-1">
				<img class="card-img-top" src="img/notepad.png" style="width: 122% " alt="Card image cap">
				</div>
				<div class="col-md-11">
				<div ><h5 class="card-title"><%= note.getTitle() %></h5></div>
				<p class="card-text"><%= note.getDescription() %></p>
				<div style="float : right">
				<a href="update-note.jsp?id=<%= note.getId() %>" class="btn btn-danger">update</a>
				<a href="delete-note?id=<%= note.getId()%>" class="btn btn-light">delete</a>
				</div>
				</div>
				</div>
			</div>
		</div>
		<% } %>
	</div>

</body>
</html>