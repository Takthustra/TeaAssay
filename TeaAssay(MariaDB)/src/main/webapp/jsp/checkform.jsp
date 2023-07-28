<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.Form"%>
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

<body id="form_body">
  <header>
    <h1>お問い合わせ</h1>
  </header>
  <main class="info_main">
    <section>
      <h2>お問い合わせ内容確認</h2>

      <p>
        名前:<c:out value="${form.getName()}" />
      </p>
      <p>
        メールアドレス:<c:out value="${form.getEmail()}" />
      </p>
      <p>
        件名:<c:out value="${form.getTitle()}" />
      </p>
      <p>
        お問い合わせ内容:<c:out value="${form.getTextArea()}" />
      </p>

      <p>
        <a href="FormServlet?action=back" >戻る</a>
        <a href="FormServlet?action=done">登録</a>
      </p>
    </section>
  </main>
  <footer>
    <div class="footer">Posted by T. Shiotani</div>
  </footer>


</body>
</html>