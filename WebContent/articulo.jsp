<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<s:head/>
<sx:head/>
<body>

<sx:tabbedpanel id="formCrud">
	<sx:div label="MODULO CRUD ARTICULO">
		<s:form action="alta.action" method="post">
			<s:push value="articulo">
				<s:hidden key="id" />
				<s:textfield key="nombre" label="NOMBRE"></s:textfield>
				<s:textfield key="precio" label="PRECIO"></s:textfield>
				<s:submit value="Aceptar"></s:submit>
				<s:reset value="Limpiar"></s:reset>
			</s:push>
		</s:form>
		<h2>LISTADO DE ARTICULOS</h2>
<br>
<table>
	<tr>
		<td>ID</td>
		<td>NOMBRE</td>
		<td>SALARIO</td>
	</tr>
	<s:iterator value="listArticulo">
	<tr>
		<td><s:property value="id"/></td>
		<td><s:property value="nombre"/></td>
		<td><s:property value="precio"/></td>
		<td>
			<s:url id="editURL" action="editar">
				<s:param name="id" value="%{id}"></s:param>
			</s:url>
			<s:a href="%{editURL}">Editar</s:a>
		</td>
		<td>
			<s:url id="deleteURL" action="baja">
				<s:param name="id" value="%{id}"></s:param>
			</s:url>
			<s:a href="%{deleteURL}">Eliminar</s:a>
		</td>
	</tr>
	</s:iterator>
</table>
</sx:div>
</sx:tabbedpanel>

</body>
</html>