<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Shopping Mall - 회원가입</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .register-form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .alert-red {
            color: #721c24;
            background-color: #f8d7da;
            border-color: #f5c6cb;
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="register-form">
                <h2 class="text-center mb-4">회원가입</h2>

                <!-- 아이디 중복 -->
                <c:if test="${not empty success and success eq '-1'}">
                    <div id="error-message" class="alert alert-red mt-3 text-center">${msg}</div>
                </c:if>
                <!-- 이메일 중복 -->
                <c:if test="${not empty success and success eq '-2'}">
                    <div id="error-message" class="alert alert-red mt-3 text-center">${msg}</div>
                </c:if>


                <form action="/signup-process.do" method="post">
                    <div class="mb-3">
                        <label for="username" class="form-label">사용자명 (영문)</label>
                        <input type="text" id="username" name="username" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">비밀번호</label>
                        <input type="password" id="password" name="password" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">이메일</label>
                        <input type="email" id="email" name="email" class="form-control" required>
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">가입 완료</button>
                    </div>
                </form>
                <div class="mt-3 text-center">
                    <!-- 로그인 페이지로 이동하는 링크 추가 -->
                    <a href="./login.do">이미 가입하셨습니까? 로그인하기</a>
                </div>

                <!-- 홈으로 가는 링크 추가 -->
                <div class="mt-3 text-center">
                    <a href="./home.do" class="btn btn-secondary">홈으로 가기</a>
                </div>

            </div>
        </div>
    </div>
</div>

<!-- 부트스트랩 스크립트 -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>

</body>
</html>
