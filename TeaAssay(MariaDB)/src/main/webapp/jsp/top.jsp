<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.AccessCount"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>茶の湯随想</title>
<link rel="stylesheet" href="css/top.css">
<script src="top.js"></script>
</head>
<body>
  <header>
    <h1>茶の湯随想</h1>
  </header>
  <div id="contents">
    <aside>
      <h2>項目</h2>
      <p>
        <a href="InfoServlet">本サイトについて</a>
      </p>
      <p>
        <a href="IntroServlet">自己紹介</a>
      </p>
      <p>
        <a href="FormServlet">お問い合わせ</a>
      </p>
    </aside>
    <main class="top_main">
      <section id="contents">
        <img class="top_photo" src="photo/matcha_powder.jpg" width="360" height="270" alt="matcha_powder">
        <div class="famous_quote">
          <h3 class="h3_top">
            茶の湯とはただ湯をわかし茶を立てて<br>
          </h3>
          <h3 class="h3_bottom">
            のむばかりなることと知るべし(千利休）<br>
          </h3>
        </div>
      </section>
    </main>
  </div>
  <footer>
    <section class="footer">
      <p>Posted by T. Shiotani</p>
      <p>
        今日のアクセス数:
        <c:out value="${applicationScope.cnt}" />
      </p>
    </section>
  </footer>
</body>
</html>