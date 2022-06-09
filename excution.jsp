<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="DAO.*,JavaBeans.* ,java.util.*" %>
    <jsp:useBean id="form" class="JavaBeans.form" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>QCM choisis est<%=form.getlib_form() %> </title>
</head>
<body>
<%!
String q,r;
List <reponse>  responsel = new ArrayList<reponse>();
List <question> questionl = new ArrayList<question>();
%>
<%
questionl = daoques.getQuest(form.getid_form());
for( question q : questionl){
%>
	<%= q.getid_question()%><b><%= q.getlib_question()%></b><br/>
	<form action="" method ="get">
	<%
 	responsel = daoRep.getResp(q.getid_question());
 	for( reponse r : responsel){%>
		<input type n ="radio" name="repQ<%=q.getid_question() %>"
		value="<%=r.getid_reponse() %>">  <label><%= r.getlib_reponse() %></label><br/>

	<% } %>
</form>



<%} %>
</body>
</html>