<%@ page import="MyServiceApp.app.sample.Doctor" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doctors</title>
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
<h1>Doctors List</h1>
<table>
<thead>
<tr>
<th>Doctor id</th>
<th>Doctor name</th>
</tr>
</thead>
<tbody>
<%
List<Doctor> doctors = (List<Doctor>)request.getAttribute("doctor");
if(!doctors.isEmpty()){
for(Doctor doctor: doctors){
%>
<tr>
<td><%= doctor.getId() %></td>
<td><%= doctor.getName() %></td>
</tr>
<%}
}else{%>
<tr>
<td colspan = "2">Doctors not found</td>
</tr>
<%
}%>
</tbody>
</table>
<br/>

<button onclick="window.location.href='index.jsp'">Go home</button>
</body>
</html>