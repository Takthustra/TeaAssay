<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>茶の湯随想</title>
<link rel="stylesheet" href="css/another.css">
<script src="tea and program.js"></script>
<title>Insert title here</title>
</head>

<body id="info_body">
  <header>
    <h1>自己紹介</h1>
  </header>
  <main class="info_main">
    <section>
      <p id=intro_jpg></p>
      <p>名前：塩谷拓斗</p>
      <p>
        生年月日：1999/02/03 年齢：
        <c:out value="${ts.getAge()}" />
        歳
      </p>
      <p>所在地:福岡県福岡市</p>
      <p>最終学歴:専門学校 経理科</p>
      <p>
        茶道歴:
        <c:out value="${ts.getTeaYear()}" />年<c:out value="${ts.getTeaMonth()}" />カ月
      </p>
      <p>流派:表千家</p>
      <p>座右の銘:前言撤回</p>
      <p>趣味：茶道、プログラミング、読書</p>
      <p>茶道を始めたきっかけ：22歳の時に岡倉天心「茶の本」の美しさに心を奪われました。</p>
      <p>一言：茶道初学者なので至らない点があればお伝えください。</p>
      <p></p>
    </section>
  </main>
  <jsp:include page="footer.jsp" />
</body>
</html>