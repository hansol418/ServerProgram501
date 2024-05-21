<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP-Model2(MVC)-todoList</title>
</head>
<body>
<h1><%= "menuReg.jsp" %>
</h1>
<br/>
<h1><%= "임시 menuReg 화면." %>
</h1>
<form method="post" action="/menu/register">
    <div>
        <input type="text" name="menuTitle" placeholder="제목을 입력해주세요.">
    </div>
    <div>
        <input type="date" name="menuRegDate">
    </div>
    <div>
        <button type="reset">초기화</button>
        <button type="submit">작성</button>
    </div>
</form>
</body>
</html>
