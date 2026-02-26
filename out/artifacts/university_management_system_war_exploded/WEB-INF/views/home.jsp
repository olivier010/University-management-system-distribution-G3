<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>University Management System - Home</title>
    <style>
        :root {
            --primary: #2357F4;
            --dark: #4A72D1;
            --light: #F4F6FB;
            --font-family: "Inter", system-ui, sans-serif;
        }
        body {
            font-family: var(--font-family);
            background-color: var(--light);
            margin: 0;
            padding: 0;
            color: #333;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        .container {
            text-align: center;
            background: #fff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            max-width: 600px;
            width: 90%;
        }
        h1 {
            color: var(--primary);
            margin-bottom: 30px;
        }
        .menu {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 20px;
        }
        .menu-item {
            display: block;
            padding: 20px;
            background-color: var(--primary);
            color: white;
            text-decoration: none;
            border-radius: 8px;
            font-size: 1.1em;
            font-weight: bold;
            transition: background-color 0.3s, transform 0.2s;
        }
        .menu-item:hover {
            background-color: var(--dark);
            transform: translateY(-2px);
        }
        .footer {
            margin-top: 40px;
            font-size: 0.9em;
            color: #666;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>University Management System</h1>
    <div class="menu">
        <a href="${pageContext.request.contextPath}/students/list" class="menu-item">Manage Students</a>
        <a href="${pageContext.request.contextPath}/lecturers/list" class="menu-item">Manage Lecturers</a>
        <a href="${pageContext.request.contextPath}/courses/list" class="menu-item">Manage Courses</a>
        <a href="${pageContext.request.contextPath}/departments/list" class="menu-item">Manage Departments</a>
    </div>
    <div class="footer">
        &copy; 2026 Group 3 - Distributed Systems
    </div>
</div>

</body>
</html>

