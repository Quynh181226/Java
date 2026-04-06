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
  <title>StudentHub - Danh sách sinh viên (Ss2)</title>
  <style>
    /* Giữ nguyên CSS như cũ */
    body { font-family: Arial, sans-serif; margin: 20px; }
    table { border-collapse: collapse; width: 100%; margin-top: 20px; }
    th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
    th { background-color: #4CAF50; color: white; cursor: pointer; }
    tr:nth-child(even) { background-color: #f2f2f2; }
    .status-green { color: green; font-weight: bold; }
    .status-orange { color: orange; font-weight: bold; }
    .status-blue { color: blue; font-weight: bold; }
    .nav { margin-bottom: 20px; }
    .nav a { margin-right: 15px; text-decoration: none; padding: 8px 15px; background-color: #008CBA; color: white; border-radius: 4px; }
    .filter-box { margin: 20px 0; padding: 15px; background-color: #f0f0f0; border-radius: 5px; }
    .info { color: #555; margin-top: 10px; }
  </style>
</head>
<body>
<div class="nav">
  <a href="${pageContext.request.contextPath}/ss2/students">Danh sách SV</a>
  <a href="${pageContext.request.contextPath}/ss2/dashboard">Dashboard</a>
  <a href="${pageContext.request.contextPath}/index.jsp">Trang chủ</a>
</div>

<h2>Danh sách sinh viên (Ss2)</h2>

<div class="filter-box">
  <strong>Sắp xếp:</strong>
  <a href="?sortBy=name">Theo tên (A-Z)</a>
  <a href="?sortBy=gpa">Theo GPA (Cao-Thấp)</a>

  <strong style="margin-left: 20px;">Lọc theo khoa:</strong>
  <a href="?faculty=Công nghệ thông tin">CNTT</a>
  <a href="?faculty=Khoa học máy tính">KHMT</a>
  <a href="?faculty=Hệ thống thông tin">HTTT</a>
  <a href="${pageContext.request.contextPath}/ss2/students">Xóa lọc</a>

  <strong style="margin-left: 20px;">Tìm kiếm:</strong>
  <form method="get" style="display: inline;">
    <input type="text" name="search" placeholder="Nhập tên sinh viên..." value="${searchKeyword}">
    <button type="submit">Tìm</button>
  </form>
</div>

<div class="info">
  Tìm thấy <strong>${totalFound}</strong> sinh viên phù hợp
</div>

<table>
  <thead>
  <tr>
    <th>STT</th>
    <th>Mã SV</th>
    <th>Họ tên</th>
    <th>Khoa</th>
    <th>Năm nhập học</th>
    <th>GPA</th>
    <th>Trạng thái</th>
    <th>Chi tiết</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="student" items="${students}" varStatus="status">
    <tr class="${status.index % 2 == 0 ? 'even' : 'odd'}">
      <td>${status.index + 1}</td>
      <td>${student.studentCode}</td>
      <td>${student.fullName}</td>
      <td>${student.faculty}</td>
      <td>${student.enrollmentYear}</td>
      <td>${student.gpa}</td>
      <td class="status-${student.status == 'Đang học' ? 'green' : (student.status == 'Bảo lưu' ? 'orange' : 'blue')}">
          ${student.status}
      </td>
      <td><a href="${pageContext.request.contextPath}/ss2/students/detail?id=${student.id}">Xem</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
