<%@ page import="ServiceApp.app.sample.Clinic" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clinics</title>
    <style>
    body{
    display:flex;
    flex-direction:column;
    align-items: center;
    }
    table{
    width:70%;
    background-color: darkgray;
    border:1px solid black;
    border-radius:5px;
    padding:10px 5px;
    tr{
    font-size: 28px;
    }
    th,td{
       font-size:16px;
       border:1px solid black;
       border-radius:3px;
       text-align:center;
    }
    th{
    color: black;
    }
    td{
    color:white;
    }
    }
    </style>
</head>
<body>
<h1>Clinics List</h1>
<table>
<thead>
<tr>
<th>Clinic id</th>
<th>Clinic name</th>
</tr>
</thead>
<tbody>
<%
List<Clinic> clinics = (List<Clinic>)request.getAttribute("clinic");
if(!clinics.isEmpty()){
for(Clinic clinic: clinics){
%>
<tr>
<td><%= clinic.getId() %></td>
<td><%= clinic.getName() %></td>
</tr>
<%}
}else{%>
<tr>
<td colspan = "2">Clinics not found</td>
</tr>
<%
}%>
</tbody>
</table>
<br/>
<h2>Add clinic</h2>
<form method = "post" action = "addClinic">
<input type = "text" name = "id" value = "write clinic id for add to table"/>
<input type = "text" name = "name" value = "write clinic name for add to table"/>
<input type = "submit">
</form>
<h2>Delete clinic</h2>
<form method = "post" action = "deleteClinic">
<input type = "text" name = "id" value = "write clinic id for delete"/>
<input type = "submit">
</form>
<button onclick="window.location.href='index.jsp'">Go home</button>
</body>
</html>