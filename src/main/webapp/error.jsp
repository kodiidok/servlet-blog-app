<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <header>
        <h1>Error Occurred</h1>
    </header>
    <nav>
        <!-- Navigation links -->
    </nav>
    <main>
        <div class="error-container">
            <h2>An error occurred while processing your request:</h2>
            <p><%= request.getAttribute("errorMessage") %></p>
            <p>Please try again later or contact support.</p>
        </div>
    </main>
    <footer>
        <p>&copy; 2023 Your Blog App</p>
    </footer>
</body>
</html>
