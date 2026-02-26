<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Save Department</title>
    <style>
        :root {
            --primary: #2357F4;
            --dark: #4A72D1;
            --light: #F4F6FB;
            --success: #26C071;
            --font-family: "Inter", system-ui, sans-serif;
        }
        body {
            font-family: var(--font-family);
            background-color: var(--light);
            margin: 0;
            padding: 20px;
            color: #333;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        h2 {
            color: var(--primary);
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"], input[type="email"], select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            background-color: var(--primary);
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: var(--dark);
        }
        .back-link {
            display: inline-block;
            margin-top: 15px;
            text-decoration: none;
            color: #666;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Department Request Form</h2>

    <form:form action="${pageContext.request.contextPath}/departments/saveDepartment" modelAttribute="department" method="POST">

        <form:hidden path="id" />

        <div class="form-group">
            <label>Name:</label>
            <form:input path="name" required="required" />
        </div>

        <div class="form-group">
            <label>Description:</label>
            <form:textarea path="description" rows="5" style="width: 100%; border: 1px solid #ddd; padding: 10px;" />
        </div>

        <button type="submit">Save Department</button>

    </form:form>

    <a href="${pageContext.request.contextPath}/departments/list" class="back-link">Back to List</a>
</div>

</body>
</html>

