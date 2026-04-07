<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List - Training Department</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f5f5f5;
        }
        h2 {
            color: #333;
            text-align: center;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
            text-align: center;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .high-salary {
            color: green;
            font-weight: bold;
        }
        .base-salary {
            color: orange;
            font-weight: bold;
        }
    </style>
</head>
<body>
<h2>Employee List - Training Department</h2>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Full Name</th>
        <th>Department</th>
        <th>Salary (USD)</th>
        <th>Đánh giá</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="emp" items="${employees}">
        <tr>
            <td style="text-align: center;">${emp.id}</td>
            <td>${emp.fullName}</td>
            <td>${emp.department}</td>
            <td style="text-align: right;">${emp.salary}</td>
            <td style="text-align: center;">
                <c:choose>
                    <c:when test="${emp.salary >= 10000}">
                        <span class="high-salary">Mức lương cao</span>
                    </c:when>
                    <c:otherwise>
                        <span class="base-salary">Mức lương cơ bản</span>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>