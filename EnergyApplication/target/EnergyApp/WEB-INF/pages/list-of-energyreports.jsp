<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of energyreports</title>
<script src="../resources/jquery.min.js" type="text/javascript"></script>
<script src="../resources/highcharts.js" type="text/javascript"></script>
<script src="../resources/jquery.highchartTable.js" type="text/javascript"></script>
</head>
<body>
<h1>List of energyreports</h1>
<p>Here you can see the list of the energyreports, edit them, remove or update.</p>
<table style="display:none;" class="highchart" data-graph-container-before="1" data-graph-type="area" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="15%">name</th><th width="10%">rating</th>
</tr>
</thead>
<tbody>
<c:forEach var="energyreport" items="${EnergyReports}">
<tr>
	<td>${energyreport.name}</td>
	<td>${energyreport.rating}</td>
</tr>
</c:forEach>
</tbody>
</table>

<table style="margin-left:auto;margin-right:auto;" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th  style="text-align:center;" width="10%">id</th><th style="text-align:center;" width="15%">name</th><th style="text-align:center;" width="10%">rating</th><th style="text-align:center;" width="10%">actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="energyreport" items="${EnergyReports}">
<tr>
	<td style="text-align:center;">${energyreport.id}</td>
	<td style="text-align:center;">${energyreport.name}</td>
	<td style="text-align:center;">${energyreport.rating}</td>
	<td style="text-align:center;">
	<a href="${pageContext.request.contextPath}/energyreport/delete/${energyreport.id}.html">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
<script>
$(document).ready(function() {
	  $('table.highchart').highchartTable();
});
</script>
</body>
</html>