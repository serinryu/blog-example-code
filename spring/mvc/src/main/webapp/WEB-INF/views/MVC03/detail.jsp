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
    <h1> ${score.name} 의 점수는 .. </h1>
    <table class="table table-striped">
        <thead>
        <th>korScore</th>
        <th>engScore</th>
        <th>mathScore</th>
        <th>total</th>
        <th>average</th>
        </thead>
        <tbody>
            <tr>
                <td>${score.korScore}입니다.</td>
                <td>${score.engScore}입니다.</td>
                <td>${score.mathScore}입니다.</td>
                <td>${score.korScore + score.engScore + score.mathScore}입니다.</td>
                <td>${(score.korScore + score.engScore + score.mathScore)/3}입니다.</td>
            </tr>
        </tbody>
    </table>
    <a href="/score/list" class="btn btn-primary"> 리스트로 돌아가기 </a>
    <form action="/score/remove" method="POST">
        <input type="hidden" name="studentNumber" value="${score.studentNumber}">
        <input type="submit" class="btn btn-secondary" value="삭제하기">
    </form>
</div>
</body>
</html>