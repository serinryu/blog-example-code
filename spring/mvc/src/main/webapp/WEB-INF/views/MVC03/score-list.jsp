<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <div>
        <table class="table table-striped">
            <thead>
                <th>name</th>
                <th>korScore</th>
                <th>engScore</th>
                <th>mathScore</th>
                <th>total</th>
                <th>average</th>
            </thead>
            <tbody>
                <!-- java의 향상된 for문 (for(var:list){})처럼 사용함-->
                <c:forEach var="score" items="${scoreList}">
                    <tr>
                        <td><a href="/score/detail?studentNumber=${score.studentNumber}">${score.name}</a></td>
                        <td>${score.korScore}입니다.</td>
                        <td>${score.engScore}입니다.</td>
                        <td>${score.mathScore}입니다.</td>
                        <td>${score.korScore + score.engScore + score.mathScore}입니다.</td>
                        <td>${(score.korScore + score.engScore + score.mathScore)/3}입니다.</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h1> 성적 등록 폼 </h1>
        <form action="/score/register" method="POST">
            <label for="user-name" class="form-label">유저이름</label>
            <input type="text" class="form-control" id="user-name" name="name">
            <label for="user-kor" class="form-label">국어성적</label>
            <input type="number" class="form-control" id="user-kor" name="korScore" min="0">
            <label for="user-eng" class="form-label">영어성적</label>
            <input type="number" class="form-control" id="user-eng" name="engScore" min="0">
            <label for="user-math" class="form-label">수학성적</label>
            <input type="number" class="form-control" id="user-math" name="mathScore" min="0">
            <input type="submit" value="제출">
        </form>
    </div>
</body>
</html>