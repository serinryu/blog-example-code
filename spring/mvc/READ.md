## 프로젝트 JDK 연결

1. File -> Project Structure 들어가기
2. Project Settings 의 SDK 를 버전에 맞게 (17 버전)
3. File -> Settings 들어가기
4. gradle 검색 후 build tools 의 gradle 항목에서 맨 하단 gradle JVM 을 2에서 설정한 버전으로 맞추기
5. 우측 상단 코끼리 모양 아이콘 누르기 (없으면 1시 방향 녹색재생버튼)


## vscode 에서 .jsp 파일 템플릿 설정하기
0. 보통 프론트단 jsp 파일은 vscode 로 작업하는 편, 인텔리제이로도 작업 가능 (선호 차이)
1. vscode 좌측 하단톱니바퀴 모양 클릭
2. 사용자 코드 조각(user snipets) 클릭 후 html 입력
3. html.json 파일에 아래 코드 복붙하고 저장
4. .jsp 파일 생성 후 !jsp 입력하면 자동완성
```agsl
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>
```