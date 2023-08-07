<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="bean.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
<link rel="stylesheet" type="text/css" href="styles/global.css">
</head>
<body>
	<header class="pageHeader center">
		<h1>Welcome to Dashboard</h1>
	</header>
	<nav>
		<!-- Navigation links -->	
	</nav>
	<main>
		<h2 class="subtitle">User List</h2>
		<ul>
			<%
			List<User> users = (List<User>) request.getAttribute("users");
			for (User user : users) {
			%>
			<li class="userCard">
				<div class="userCardContainer">
					<p>
						Username:
						<%=user.getUsername()%></p>
					<p>
						Full Name:
						<%=user.getFullname()%></p>
					<p>
						Email:
						<%=user.getEmail()%></p>
				</div>
				<button class="btn" id="editButton">Edit</button>
			</li>
			<%
			}
			%>
		</ul>
	</main>
	<footer class="center">
		<p>&copy; 2023 Your Blog App</p>
	</footer>

	<div id="editModal" class="modal">
		<div class="modal-content">
			<span class="close">&times;</span>
			<h2>Edit User Details</h2>
			<form id="editForm" class="edit-form">
				<!-- Input fields for editing user details -->
				<div class="input-field-container">
					<div>
						<label for="username">Username:</label> <input class="input-field"
							type="text" id="username" name="username" value="">
					</div>
					<div>
						<label for="fullname">Full Name:</label> <input
							class="input-field" type="text" id="fullname" name="fullname"
							value="">
					</div>
					<div>
						<label for="email">Email:</label> <input class="input-field"
							type="text" id="email" name="email" value="">
					</div>
				</div>
				<!-- Add more input fields as needed -->
				<div id="save-button-container">
					<button type="submit" id="saveButton" class="btn">Save</button>
				</div>
			</form>
		</div>
	</div>
	<script src="scripts/dashboard.js"></script>
</body>
</html>
