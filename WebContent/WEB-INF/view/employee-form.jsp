<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>Save Employee</title>

<!-- reference our style sheet  -->
<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css " />
		
<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-employee-style.css " />

</head>

<body>


	<div id="wrapper">
			<div id="header">
			  	<h2> Employee Save</h2>
			</div>
		</div>
		
		<div id="container">
		
		  <h3>Save Employee</h3>
		  
		  <form:form action="saveEmployee" modelAttribute="employees" method="POST" >
		  
		  <!-- associate this data with employee id -->

		  
		  <table>
		  
		  	<tbody>
		  	 		<tr>
		  	 		
		  	 		<td><label>Id:</label></td>
		  	 		<td><form:input path="id" /></td>
		  	 		</tr>
		  	 		
		  	 		<tr>
		  	 		
		  	 		<td><label>Name:</label></td>
		  	 		<td><form:input path="employeeName" /></td>
		  	 		</tr>
		  	 		
		  	 		<tr>
		  	 		
		  	 		<td><label></label></td>
		  	 		<td><input type="submit" value="Save" class="save" /></td>
		  	 		</tr>
		  	
		  	
		  	</tbody>
		  
		  
		  </table>
		  
		  </form:form>
		  
		  <div style ="clear; both;" ></div>
		  
		  <p>
		  <a href="${pageContext.request.contextPath}/employee/employeelist ">Back to list</a>
		  </p>
			
		</div>

</body>
</html>