<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>University Management - Students</title>
    <style>
        :root {
            --primary: #2357F4;
            --dark: #4A72D1;
            --light: #F4F6FB;
            --success: #26C071;
            --warning: #F1C40F;
            --danger: #E74C3C;
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
            max-width: 1000px;
            margin: 0 auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h2 {
            color: var(--primary);
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            text-align: left;
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: var(--primary);
            color: white;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        .pagination {
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 10px;
            margin-top: 20px;
        }
        .pagination a {
            padding: 8px 16px;
            text-decoration: none;
            color: var(--primary);
            border: 1px solid var(--primary);
            border-radius: 4px;
            transition: background-color 0.3s;
        }
        .pagination a:hover {
            background-color: var(--primary);
            color: white;
        }
        .pagination span {
            font-weight: bold;
        }
        .status-active {
            color: var(--success);
            font-weight: bold;
        }
        h2 {
            color: var(--primary);
            margin-bottom: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .home-link {
            font-size: 0.8em;
            text-decoration: none;
            color: #666;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>
        Student Management
        <a href="${pageContext.request.contextPath}/" class="home-link">Back to Home</a>
    </h2>

    <div style="margin-bottom: 20px;">
        <a href="${pageContext.request.contextPath}/students/showFormForAdd" style="padding: 10px 15px; background-color: var(--success); color: white; text-decoration: none; border-radius: 4px;">Add Student</a>
    </div>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>DoB</th>
                <th>Department</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${students}">
                <c:url var="updateLink" value="/students/showFormForUpdate">
                    <c:param name="studentId" value="${student.id}" />
                </c:url>
                <c:url var="deleteLink" value="/students/delete">
                    <c:param name="studentId" value="${student.id}" />
                </c:url>
                <tr>
                    <td>${student.id}</td>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>${student.email}</td>
                    <td>${student.dateOfBirth}</td>
                    <td>${student.departmentName}</td>
                    <td>
                        <a href="${updateLink}" style="color: var(--warning);">Edit</a> |
                        <a href="${deleteLink}" style="color: var(--danger);" onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty students}">
                <tr>
                    <td colspan="6" style="text-align: center;">No students found.</td>
                </tr>
            </c:if>
        </tbody>
    </table>

    <div class="pagination">
        <c:if test="${currentPage > 1}">
            <a href="?page=${currentPage - 1}&size=${pageSize}">Previous</a>
        </c:if>

        <span>Page ${currentPage} of ${totalPages}</span>

        <c:if test="${currentPage < totalPages}">
            <a href="?page=${currentPage + 1}&size=${pageSize}">Next</a>
        </c:if>
    </div>
</div>

</body>
</html>

