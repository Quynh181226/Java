<%--
  Created by IntelliJ IDEA.
  User: TDG
  Date: 06/04/2026
  Time: 8:33 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard - Thống kê Ss2</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .stats-container { display: flex; flex-wrap: wrap; gap: 20px; margin-top: 20px; }
        .stat-card { border: 1px solid #ddd; padding: 20px; border-radius: 8px; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; min-width: 200px; }
        .stat-number { font-size: 36px; font-weight: bold; margin: 10px 0; }
        .stat-label { font-size: 14px; opacity: 0.9; }
        .status-stats { margin-top: 30px; }
        .status-item { margin: 15px 0; padding: 10px; background-color: #f0f0f0; border-radius: 5px; }
        .status-bar { height: 30px; color: white; padding: 5px; text-align: center; border-radius: 3px; }
        .nav { margin-bottom: 20px; }
        .nav a { margin-right: 15px; text-decoration: none; padding: 8px 15px; background-color: #008CBA; color: white; border-radius: 4px; }
        .valedictorian { background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%); color: white; padding: 20px; border-radius: 8px; margin-top: 20px; }
    </style>
</head>
<body>
<div class="nav">
    <a href="${pageContext.request.contextPath}/ss2/students">Danh sách SV</a>
    <a href="${pageContext.request.contextPath}/ss2/dashboard">Dashboard</a>
</div>

<h2>Báo cáo Tổng quan (Ss2)</h2>

<div class="stats-container">
    <div class="stat-card">
        <div class="stat-label">Tổng số sinh viên</div>
        <div class="stat-number">${totalStudents}</div>
    </div>
    <div class="stat-card">
        <div class="stat-label">GPA Trung bình</div>
        <div class="stat-number">${String.format("%.2f", averageGpa)}</div>
    </div>
</div>

<div class="status-stats">
    <h3>Tỷ lệ sinh viên theo trạng thái</h3>
    <c:forEach items="${statusPercentage}" var="entry">
        <div class="status-item">
            <strong>${entry.key}</strong><br>
            <div class="status-bar" style="width: ${entry.value}%; background-color:
                ${entry.key == 'Đang học' ? '#4CAF50' : (entry.key == 'Bảo lưu' ? '#FF9800' : '#2196F3')};">
                    ${String.format("%.1f", entry.value)}%
            </div>
        </div>
    </c:forEach>
</div>

<div class="valedictorian">
    <h3>🏆 Thủ khoa của nhóm</h3>
    <p style="font-size: 18px;"><strong>${valedictorian.fullName}</strong> - ${valedictorian.studentCode}</p>
    <p>GPA: ${valedictorian.gpa} | Khoa: ${valedictorian.faculty}</p>
</div>
</body>
</html>