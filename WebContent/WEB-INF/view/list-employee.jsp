<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>List-Employee</title>

<!-- reference our style sheet  -->
<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css " />

</head>

<body>
    
		<div id="wrapper">
			<div id="header">
			  	<h2> Employee List</h2>
			</div>
		</div>
		
		<div id="container">
			<div id="content">
			
			<!-- put a new button to add employees -->
			<input type="button" value="Add Employee"
				onclick="window.location.href='showFormForAdd'; return false"
				class="add-button"/>
				
				
			
		      <!-- add html table here -->	
		      <table>
		      
		      
		      		<tr>
		      		
		      				<th>Id</th>
		      				<th>Name</th>
		      				<th>Action</th>
		      		
		      		</tr>
		      		
		      		<!-- loop over and print the employees -->
		      		
		      		<c:forEach var="tempEmployee" items="${employees}">
		      		
		      		<!-- construct an update link with employee id -->
		      		<c:url var="updateLink" value="/employee/showFormForUpdate" >
		      			<c:param name="id" value="${tempEmployee.id }" />
		      		</c:url>
		      		
		      		<!-- construct a delete link with employee id -->
		      		<c:url var="deleteLink" value="/employee/showFormForDelete" >
		      			<c:param name="id" value="${tempEmployee.id }" />
		      		</c:url>
		      		
		      		
		      		<tr> 
		      				<td> ${tempEmployee.id}</td>
		      				<td> ${tempEmployee.employeeName}</td>
		      				<td> 
		      				<!-- display the update link -->
		      				<a href="${updateLink}">Update</a>
		      				|
		      				<a href="${deleteLink}"
		      				onclick="if(!(confirm('Are you sure, you want to delete this employee ?'))) return false">Delete</a>
		      				</td>
		      		</tr>
		      	
		      		</c:forEach>
		      
		      </table>
		
			</div>
		
		</div>

</body>
</html>