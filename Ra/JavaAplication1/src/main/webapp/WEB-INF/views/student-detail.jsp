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
  <title>Chi tiết sinh viên - Ss2</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 20px; }
    .detail-card { border: 1px solid #ddd; padding: 20px; width: 500px; border-radius: 8px; background-color: #f9f9f9; }
    .detail-row { margin: 15px 0; }
    .label { font-weight: bold; display: inline-block; width: 150px; }
    .value { display: inline-block; }
    .back-btn { margin-top: 20px; }
    .back-btn a { padding: 8px 15px; background-color: #008CBA; color: white; text-decoration: none; border-radius: 4px; }
    .nav { margin-bottom: 20px; }
    .nav a { margin-right: 15px; text-decoration: none; padding: 8px 15px; background-color: #008CBA; color: white; border-radius: 4px; }
  </style>
</head>
<body>
<div class="nav">
  <a href="${pageContext.request.contextPath}/ss2/employees">Danh sách SV</a>
  <a href="${pageContext.request.contextPath}/ss2/dashboard">Dashboard</a>
</div>

<h2>Chi tiết sinh viên</h2>

<div class="detail-card">
  <div class="detail-row">
    <span class="label">Mã sinh viên:</span>
    <span class="value">${employee.studentCode}</span>
  </div>
  <div class="detail-row">
    <span class="label">Họ tên:</span>
    <span class="value">${employee.fullName}</span>
  </div>
  <div class="detail-row">
    <span class="label">Khoa:</span>
    <span class="value">${employee.faculty}</span>
  </div>
  <div class="detail-row">
    <span class="label">Năm nhập học:</span>
    <span class="value">${employee.enrollmentYear}</span>
  </div>
  <div class="detail-row">
    <span class="label">GPA:</span>
    <span class="value">${employee.gpa}</span>
  </div>
  <div class="detail-row">
    <span class="label">Trạng thái:</span>
    <span class="value" style="color: ${employee.status == 'Đang học' ? 'green' : (employee.status == 'Bảo lưu' ? 'orange' : 'blue')};">
      ${employee.status}
    </span>
  </div>
</div>

<div class="back-btn">
  <a href="${pageContext.request.contextPath}/ss2/employees">Quay lại danh sách</a>
</div>
</body>
</html>
