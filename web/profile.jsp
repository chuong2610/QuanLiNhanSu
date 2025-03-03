<%-- 
    Document   : profile
    Created on : Mar 2, 2025, 10:28:35 PM
    Author     : ADMIN
--%>

<%@page import="dto.AttendenceDTO"%>
<%@page import="java.util.List"%>
<%@page import="dto.EmployeeDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Nhân Sự - Quán Cà Phê</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
         * {
            box-sizing: border-box;
        }
        body {
            font-family: 'Poppins', sans-serif;
            background: #eceff1;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            margin: 0;
        }
        .sidebar {
            width: 280px;
            height: 100vh;
            background: #37474f;
            color: white;
            position: fixed;
            padding: 30px 20px;
        }
        .sidebar h3 {
            text-align: center;
            font-weight: bold;
            margin-bottom: 20px;
        }
        .sidebar a {
            color: white;
            text-decoration: none;
            display: block;
            padding: 12px 20px;
            font-size: 16px;
            border-radius: 8px;
            margin: 8px 0;
            transition: 0.3s;
        }
        .sidebar a:hover {
            background: #546e7a;
        }
        .header {
            position: fixed;
            width: calc(100% - 280px);
            height: 70px;
            left: 280px;
            background: #263238;
            color: white;
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 0 20px;
        }
        .profile {
            display: flex;
            align-items: center;
        }

        .profile a {
            color: white;
            text-decoration: none;
            margin-right: 10px;
        }

        .profile img {
            width: 40px;
            height: 40px;
            border-radius: 50%;
        }
        .content {
            margin-left: 280px;
            padding: 90px 30px;
        }
        .footer {
            margin-left: 280px;
            background: #37474f;
            color: white;
            text-align: center;
            padding: 15px 0;
            margin-top: auto;
        }

        .profile-container {
            display: flex;
            align-items: center;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }
        .profile-container img {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            margin-right: 20px;
        }
        .salary-container, .table-container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
        }
        
    </style>
</head>
<body>
    <div class="sidebar">
        <h3 class="text-center">☕ Nhà Meo Coffee</h3>
        <a href="#">📋 Quản Lý Nhân Viên</a>
        <a href="#">⏱ Chấm Công & Lịch Làm</a>
        <a href="#">💰 Tính Lương</a>
        <a href="#">📊 Báo Cáo</a>
        <a href="#">⚙️ Cài Đặt</a>
    </div>
    <div class="header">
        <h4>Quản Lý Nhân Sự</h4>
        <div class="profile">
            <a href="#">My Profile</a>
            <img src="https://via.placeholder.com/40" alt="Profile Picture">
        </div>
    </div>
    
    <%
        EmployeeDTO edto = (EmployeeDTO) request.getAttribute("adto");
        List<AttendenceDTO> attendences = (List<AttendenceDTO>) request.getAttribute("attendences");
    %>
    
    <div class="content">
        <h2 class="mb-3">Thông Tin Cá Nhân</h2>
        <div class="profile-container">
            <img src="https://via.placeholder.com/100" alt="Profile Picture">
            <div>
                <p><strong>Tên:</strong> <%=edto.getName()%></p>
                <p><strong>Email:</strong> <%=edto.getEmail()%></p>
                <p><strong>Điện thoại:</strong> <%=edto.getPhone()%></p>
                <p><strong>Vị trí:</strong> <%=edto.getRoleDTO().getName()%></p>
            </div>
        </div>
        <div class="salary-container mt-4">
            <h4>Chọn Tháng</h4>
            <input type="month" class="form-control" id="month-picker">
            <p class="mt-3"><strong>Lương:</strong> <span id="salary">1,000,000 VND</span></p>
        </div>
        <div class="table-container mt-4">
            <h3>Bảng Chấm Công</h3>
            <table class="table table-bordered text-center">
                <thead class="table-dark">
                    <tr>
                        <th>Ngày</th>
                        <th>Check-in</th>
                        <th>Check-out</th>
                        <th>Thưởng/Phạt</th>
                    </tr>
                </thead>
                <tbody>
                    <% for(AttendenceDTO adto : attendences){%>
                    <tr>
                        <td><%=adto.getTimeCheckIn().getDayOfMonth()+"/"+adto.getTimeCheckIn().getMonthValue()+"/"+adto.getTimeCheckIn().getYear()%></td>
                        <td><%=String.format("%02d:%02d", adto.getTimeCheckIn().getHour(), adto.getTimeCheckIn().getMinute())%></td>
                        <td><%=String.format("%02d:%02d", adto.getTimeCheckOut().getHour(), adto.getTimeCheckOut().getMinute())%></td>
                        <td>0 VND</td>
                    </tr>
                   
                    
                    <%}%>
                </tbody>
            </table>
        </div>
    </div>
    <div class="footer">
        <p>&copy; 2025 Quán Cà Phê. All rights reserved.</p>
    </div>
    <script>
        document.getElementById('month-picker').addEventListener('change', function() {
            document.getElementById('salary').textContent = '1,200,000 VND';
        });
    </script>
</body>
</html>
